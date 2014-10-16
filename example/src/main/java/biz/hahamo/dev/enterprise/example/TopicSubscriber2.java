package biz.hahamo.dev.enterprise.example;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

/**
 * Simple subscriber to a broadcasted topic.
 * 
 * @author GHajba
 *
 */
@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "example.topic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class TopicSubscriber2 extends AbstractTopicSubscriber {

    public TopicSubscriber2() {
        this.name = "Subscriber 2";
    }
}
