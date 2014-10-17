package biz.hahamo.dev.enterprise.example.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "CIRCLE")
// @Table(name = "SHAPE_SINGLETABLE")
public class CircleSingletable extends ShapeSingletable {

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
