package biz.hahamo.dev.enterprise.example;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Reads messages from a queue.
 * 
 * @author GHajba
 *
 */
@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "example.queue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class QueueReader implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                System.out.println("TextMessage received: " + ((TextMessage) message).getText());
            } else if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                if (objectMessage instanceof QueueObject) {
                    QueueObject queueObject = (QueueObject) objectMessage.getObject();
                    System.out.println(String.format("QueueObject found. ID is %d and the message is: %s", queueObject.getId(),
                            queueObject.getMessage()));
                } else {
                    System.out.println("ObjectMessage received of type" + objectMessage.getObject().getClass());
                }

            } else {
                System.out.println("Unknown message type:" + message.getClass());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
