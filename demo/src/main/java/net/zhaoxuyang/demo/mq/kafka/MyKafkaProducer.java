package net.zhaoxuyang.demo.mq.kafka;

/**
 *
 * @author zhaoxuyang
 */
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MyKafkaProducer {

    //broker地址，多个地址用逗号分割
    static String servers = "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094";
    static String topic = "topic1";
    static String msg = "这是一条消息";

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
            while (true) {
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, msg);
                kafkaProducer.send(record);
                System.out.println("消息发送成功:" + msg);
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

}
