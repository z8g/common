package net.zhaoxuyang.demo.mq.kafka;

/**
 *
 * @author zhaoxuyang
 */
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class Clear {

    static String servers = KafkaProperties.SERVERS;//broker地址，多个地址用逗号分割
    static String topic = KafkaProperties.CURRENT_TOPIC;
    //消费组id，在同一个消费组无法重复消费
    static String consumerGroupId = "g1";
    private static long POLL_TIMEOUT = 1000;
    private static int SIZE = 100;

    public static void main(String[] args) throws InterruptedException {

        Properties p = new Properties();
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);//不自动提交
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(p);
        kafkaConsumer.subscribe(Collections.singletonList(topic));// 订阅消息

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(POLL_TIMEOUT);
            if(!records.isEmpty()){
                System.out.println("[topic]\t[offset]\t[partition]\t[消息]");
            }
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(
                        record.topic() + '\t'
                        + record.offset() + '\t'
                        + record.partition() + '\t'
                        + record.value()
                );
            }
        }
    }


}
