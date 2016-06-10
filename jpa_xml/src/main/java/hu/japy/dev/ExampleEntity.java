package hu.japy.dev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The example entity for this article.
 * 
 * @author GHajba
 *
 */
@Entity
public class ExampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String createdBy;

    /**
     * This empty constructor is because of hibernate.
     */
    ExampleEntity() {
    }

    /**
     * Simple constructor
     *
     * @param createdBy
     *            the name of the creator
     */
    public ExampleEntity(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " / created by: " + this.createdBy;
    }

}
