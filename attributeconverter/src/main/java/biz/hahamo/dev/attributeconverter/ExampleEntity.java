package biz.hahamo.dev.attributeconverter;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author GHajba
 *
 */
@Entity
public class ExampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate created;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return this.created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " / created: " + this.created.toString();
    }

}
