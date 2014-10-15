package biz.hahamo.dev.enterprise.example;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * Sends messages to a queue.
 * 
 * @author GHajba
 */
public class QueueSender {

    @Resource(lookup = "ExampleConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "example.queue")
    private Queue queue;

    public void postTestMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);

        messageProducer.send(session.createTextMessage("Hello JMS example!"));
    }

    public void postTextObjectMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);

        messageProducer.send(session.createObjectMessage("Hello JMS example!"));
    }
}
