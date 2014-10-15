package biz.hahamo.dev.javaee.example;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Simple example entity to demonstrate an ORA-01795 exception.
 * 
 * @author GHajba
 * 
 */
@Entity
public class TestEntity implements Serializable {

    private static final long serialVersionUID = 4466268135555891310L;

    @Id
    private Long id;

}
