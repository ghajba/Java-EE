package biz.hahamo.dev.enterprise.example.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorValue(value = "CIRCLE")
@Table(name = "CIRCLE_PERCLASS")
public class CirclePerclass extends ShapePerclass {

    private static final long serialVersionUID = 667923770892268408L;

    @Column(name = "RADIUS")
    private Integer radius;

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
