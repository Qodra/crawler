/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufjf.queue;

/**
 *
 * @author jayme
 */
import org.apache.activemq.ActiveMQConnectionFactory;
 
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class QueueActiveMQ {
    
    private static final String AMQ_SERVER = "tcp://[ip]:61616";
    private static final String AMQ_USERNAME = "username";
    private static final String AMQ_PASSWORD = "password";
    private static final String QUEUE_DESTINATION = "qodra.Crawler.RdfStore";
    
    public void send(String rdf){
        try {
            	
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(AMQ_USERNAME, AMQ_PASSWORD, AMQ_SERVER);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(QUEUE_DESTINATION);

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages	
            TextMessage message = session.createTextMessage(rdf);

            // Tell the producer to send the message
            System.out.println("Sent message: "+ rdf + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();

        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }

    }
    
}
