package net.zhaoxuyang.demo.mq.activemq.e1;


import javax.jms.Connection;  
import javax.jms.ConnectionFactory;  
import javax.jms.Destination;  
import javax.jms.JMSException;  
import javax.jms.MessageConsumer;  
import javax.jms.Session;  
import org.apache.activemq.ActiveMQConnectionFactory;
  
public class Consumer {  
  
    private static String brokerURL = "tcp://localhost:61616";  
    private static transient ConnectionFactory factory;  
    private transient Connection connection;  
    private transient Session session;  
      
    public Consumer() throws JMSException {  
        factory = new ActiveMQConnectionFactory(brokerURL);  
        connection = factory.createConnection();  
        connection.start();  
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
    }  
      
    public void close() throws JMSException {  
        if (connection != null) {  
            connection.close();  
        }  
    }      
      
    public static void main(String[] args) throws JMSException {  
        Consumer consumer = new Consumer();  
        String[] stocks = {"ORCL"};
        for (String stock : stocks) {  
            Destination destination = consumer.getSession().createTopic("STOCKS." + stock);  
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);  
            messageConsumer.setMessageListener(new Listener());  
        }  
    }  
      
    public Session getSession() {  
        return session;  
    }  
  
}  
