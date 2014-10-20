package biz.hahamo.dev.enterprise.example.singletable;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "TYPE")
// @Table(name = "SHAPE_SINGLETABLE")
public abstract class ShapeSingletable implements Serializable {

    private static final long serialVersionUID = 8917616829186723579L;

    @Id
    private String idString;

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

}
