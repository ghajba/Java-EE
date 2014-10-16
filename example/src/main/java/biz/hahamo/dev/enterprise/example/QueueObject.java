package biz.hahamo.dev.enterprise.example;

import java.io.Serializable;

/**
 * Simple object to send to queues
 * 
 * @author GHajba
 */
public class QueueObject implements Serializable {

    private static final long serialVersionUID = 1312534789768196875L;

    private final String message;
    private final Long id;

    public QueueObject(String message, Long id) {
        this.message = message;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}
