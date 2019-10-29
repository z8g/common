package net.zhaoxuyang.demo.mq.kafka;

/**
 *
 * @author zhaoxuyang
 */
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static java.util.stream.Collectors.toList;
import org.apache.activemq.util.TimeUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyKafkaConsumer {

    static String servers = KafkaProperties.SERVERS;//broker地址，多个地址用逗号分割
    static String topic = KafkaProperties.CURRENT_TOPIC;
    //消费组id，在同一个消费组无法重复消费
    static String consumerGroupId = "iot-report-gps-event-baidu";
    private static long POLL_TIMEOUT = 1000;
    private static int SIZE = 100;
    static final Logger LOG = LoggerFactory.getLogger(MyKafkaConsumer.class);
    static KafkaConsumer<String, String> kafkaConsumer;
    static Properties p;
    
    public static void main(String[] args) throws InterruptedException {
        p = new Properties();
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);//不自动提交
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);

        kafkaConsumer = new KafkaConsumer<>(p);
        kafkaConsumer.subscribe(Collections.singletonList(topic));// 订阅消息

        while (true) {
            Iterator<ConsumerRecord<String, String>> messageIter
                    = kafkaConsumer.poll(POLL_TIMEOUT)
                            .records(topic)
                            .iterator();//拉取消息
            processMessageList(messageIter, kafkaConsumer);
        }
    }

    private static void processMessageList(
            Iterator<ConsumerRecord<String, String>> messageIter,
            KafkaConsumer<String, String> consumer
    ) {
        Map<TopicPartition, OffsetAndMetadata> offsetMap = new HashMap<>(9);
        Map<TopicPartition, OffsetAndMetadata> preOffsetMap = new HashMap<>(9);
        int count = 0;

        while (messageIter.hasNext()) {
            //每次处理SIZE条消息
            List<ConsumerRecord<String, String>> messageList
                    = getMessageList(messageIter, SIZE, preOffsetMap, offsetMap);

            //将消息取出转换成字符串列表
            List<String> recordList = messageList.stream()
                    .map(ConsumerRecord::value)
                    .collect(toList());

            System.out.println("recordList=" + recordList.size());
            try {
                boolean result = false;
                if (result) {
                    count += messageList.size();
                    commitKafka(consumer, offsetMap);//提交Kafka
                } else {
                    System.out.println("回滚 OffsetMap-pre: " + preOffsetMap);
                    System.out.println("回滚 OffsetMap-cur: " + offsetMap);
                    //commitKafka(consumer, preOffsetMap);//提交Kafka
                }
            } catch (Exception e) {
                LOG.error(e.toString());
                //commitKafka(consumer, preOffsetMap);
            }
        }
        if (count > 0) {
            System.out.println("处理的消息数: " + count);
        }
        waitKafka(count);//处理完后睡眠一段时间，等待Kafka消息
    }

    /**
     * 获取消息列表
     *
     * @param messageIter 消息迭代器
     * @param msgSize 要处理的消息大小
     * @param offsetMap 会被重新设置
     * @return 处理完后的消费者记录
     */
    private static List<ConsumerRecord<String, String>> getMessageList(
            final Iterator<ConsumerRecord<String, String>> messageIter,
            int msgSize,
            Map<TopicPartition, OffsetAndMetadata> preOffsetMap,
            Map<TopicPartition, OffsetAndMetadata> offsetMap
    ) {

        List<ConsumerRecord<String, String>> messageList = Lists.newArrayList();
        int k = msgSize;
        offsetMap.clear();

        while (messageIter.hasNext() && k > 0) {
            ConsumerRecord<String, String> record = messageIter.next();

            System.out.println(record.topic() + '\t' + record.offset() + '\t'
                    + record.partition() + '\t' + record.value());

            messageList.add(record);
            int partition = record.partition();

            TopicPartition tp = new TopicPartition(record.topic(), partition);
            OffsetAndMetadata oam = new OffsetAndMetadata(record.offset() + 1);
            offsetMap.put(tp, oam);

            OffsetAndMetadata preOam = new OffsetAndMetadata(record.offset());
            if (!preOffsetMap.containsKey(tp)) {
                preOffsetMap.put(tp, preOam);
            }
            System.out.println(preOffsetMap);

            k--;
        }
        if (messageList.size() > 0) {
            System.out.println("messageList:" + messageList.size());
        }
        return messageList;
    }

    /**
     * 提交Kafka
     *
     * @param consumer 消费者
     * @param offsetMap 偏移量映射
     */
    private static void commitKafka(KafkaConsumer<String, String> consumer,
            Map<TopicPartition, OffsetAndMetadata> offsetMap) {
        try {
            consumer.commitSync(offsetMap);
        } catch (Exception ex) {

        }
    }

    private static void waitKafka(int count) {
        int timeout = (SIZE - count) * 15;
        if (timeout > 0) {
            try {
                //System.out.println("Kafka休眠(ms): "+timeout);
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }

    }

}
