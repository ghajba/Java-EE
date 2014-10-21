package biz.hahamo.dev.enterprise.example.tableperclass;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ShapePerclass implements Serializable {

    private static final long serialVersionUID = 8917616829186723579L;

    @Id
    private String idString;

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    @Override
    public String toString() {
        return "idString: " + idString;
    }

}
