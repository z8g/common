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

public class MyKafkaConsumer {
    //broker地址，多个地址用逗号分割
    static String servers = "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094";
    //消费组id，在同一个消费组无法重复消费
    static String consumerGroupId = "cg1";
    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG,consumerGroupId );

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(p);
        kafkaConsumer.subscribe(Collections.singletonList("cg1"));// 订阅消息
        
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format("topic:%s,offset:%d,消息:%s",
                        record.topic(), record.offset(), record.value()));
            }
        }
    }
    
}