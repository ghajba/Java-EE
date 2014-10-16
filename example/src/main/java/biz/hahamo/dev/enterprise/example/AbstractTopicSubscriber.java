package biz.hahamo.dev.enterprise.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Abstract base class for topic subscribers
 * 
 * @author GHajba
 *
 */
public abstract class AbstractTopicSubscriber implements MessageListener {

    protected String name;

    public void print(String message) {
        System.out.println(name + " " + message);
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                print("TextMessage received: " + ((TextMessage) message).getText());
            } else if (message instanceof ObjectMessage) {
                print("ObjectMessage received.");
            } else {
                print("Unknown message type:" + message.getClass());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
