package biz.hahamo.dev.enterprise.example;

import java.io.Serializable;

/**
 * Simple object to send as a broadcasted topic message.
 * 
 * @author GHajba
 *
 */
public class TopicObject implements Serializable {

    private static final long serialVersionUID = 2046045914967129142L;

    private final String message;
    private final Long id;

    public TopicObject(String message, Long id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

}
