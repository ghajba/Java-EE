package biz.hahamo.dev.enterprise.example;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.jms.JMSException;

/**
 * Simple test bean to call various methods to send messages to the queue or topic.
 * 
 * @author GHajba
 *
 */
@SessionScoped
public class TestBean {

    @Inject
    private QueueSender sender;

    @Inject
    private TopicBroadcaster broadcaster;

    public TestBean() {
    }

    public void sendTextMessageToQueue(ActionEvent event) throws JMSException {
        sender.postTestMessage();
    }

    public void sendObjectMessageToQueue(ActionEvent event) throws JMSException {
        sender.postTextObjectMessage();
    }

    public void broadcastTextMessage(ActionEvent event) throws JMSException {
        broadcaster.postTestMessage();
    }

    public void broadcastObjectMessage(ActionEvent event) throws JMSException {
        broadcaster.postObjectMessage();
    }
}