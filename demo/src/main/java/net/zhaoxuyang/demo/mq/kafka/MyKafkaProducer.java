package net.zhaoxuyang.demo.mq.kafka;

/**
 *
 * @author zhaoxuyang
 */
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MyKafkaProducer {

    //broker地址，多个地址用逗号分割
    static String servers = KafkaProperties.SERVERS;
    static String topic = KafkaProperties.CURRENT_TOPIC;
    //static String msg = "{\"bike_sn\":\"807410149\",\"city_id\":73,\"report\":{\"esn\":\"808571613\",\"ver\":\"3_1\",\"dty\":0,\"cmd\":2,\"sen\":210,\"ts\":1571129335709,\"info\":{\"esn\":\"808571613\",\"soc\":0,\"wifiList\":[],\"lon\":0,\"mcc\":460,\"cellid\":20628,\"soh\":0,\"lac\":4219,\"tDis\":251,\"result\":255,\"sig\":6530,\"hSpe\":0,\"azi\":92,\"vol\":1.15,\"arc\":0,\"sen\":210,\"tem\":-273.1,\"lat\":0,\"ele\":0,\"st\":0,\"mnc\":0,\"top5s\":\"00000000000000000000\",\"dataType\":0,\"alt\":0,\"sDis\":54,\"gSpe\":0,\"reserved\":\"AA==\",\"ts\":1571129295000}},\"ts\":1571129335719}";

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
            for (int index = 0; index < 10; index++) {
                String msg = "msg" + index;
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, msg, msg);
                kafkaProducer.send(record);
                System.out.println("消息发送成功: " + msg);
            }
        }
    }

}
