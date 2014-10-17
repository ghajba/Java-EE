package biz.hahamo.dev.enterprise.example.tableperclass;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn(name = "TYPE")
@Table(name = "SHAPE_PERCLASS")
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

}
