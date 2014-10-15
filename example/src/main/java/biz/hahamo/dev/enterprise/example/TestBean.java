package biz.hahamo.dev.enterprise.example;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
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

    public void testIt(ActionEvent event) {

    }
}