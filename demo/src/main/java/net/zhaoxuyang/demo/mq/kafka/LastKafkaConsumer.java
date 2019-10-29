package net.zhaoxuyang.demo.mq.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 *
 * @author zhaoxuyang
 */
public class LastKafkaConsumer {

    static final String TOPIC = KafkaProperties.CURRENT_TOPIC;
    static final String CONSUMER_GROUP_ID = "g1";//消费组id，在同一个消费组无法重复消费
    static final Duration POLL_TIMEOUT = Duration.ofSeconds(1000);
    static final Properties CONSUMER_PROPERTIES;
    static final int PROCESS_SIZE = 100;//每次处理的大小
    static KafkaConsumer<String, String> kafkaConsumer;

    static {
        CONSUMER_PROPERTIES = new Properties();
        CONSUMER_PROPERTIES.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);//不自动提交
        CONSUMER_PROPERTIES.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.SERVERS);
        CONSUMER_PROPERTIES.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        CONSUMER_PROPERTIES.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        CONSUMER_PROPERTIES.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
    }

    public static void main(String[] args) throws InterruptedException {
        kafkaConsumer = new KafkaConsumer<>(CONSUMER_PROPERTIES);
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(POLL_TIMEOUT);
            if (!records.isEmpty()) {
                System.out.println("[topic]\t[offset]\t[partition]\t[消息]");
            }
            int partitionSize = kafkaConsumer.partitionsFor(TOPIC).size();
            //System.out.println(kafkaConsumer.partitionsFor(TOPIC));
            Map<TopicPartition, OffsetAndMetadata> curOffsetMap = new HashMap<>(partitionSize);
            Map<TopicPartition, OffsetAndMetadata> preOffsetMap = new HashMap<>(partitionSize);

            for (ConsumerRecord<String, String> record : records) {
                System.out.println(
                        record.topic() + '\t'
                        + record.offset() + '\t'
                        + record.partition() + '\t'
                        + record.value()
                );
                String recordTopic = record.topic();
                int recordPartition = record.partition();
                long recordOffset = record.offset();

                TopicPartition tp = new TopicPartition(recordTopic, recordPartition);
                OffsetAndMetadata oam = new OffsetAndMetadata(recordOffset);

                curOffsetMap.put(tp, oam);
                preOffsetMap.putIfAbsent(tp, oam);
            }
            System.out.println("curOffsetMap: " + curOffsetMap);
            System.out.println("preOffsetMap: " + preOffsetMap);

            boolean reportResult = Math.random() > 0.8;
            if (!reportResult) {
                System.out.println("reportResult==false\n");

                preOffsetMap.entrySet().forEach((e) -> {
                    kafkaConsumer.seek(e.getKey(), e.getValue().offset());
                });
            } else {
                System.out.println("reportResult==true\n");

                kafkaConsumer.commitSync(curOffsetMap);
            }
        }
    }
}
