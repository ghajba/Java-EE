package biz.hahamo.dev.enterprise.example.tableperclass;

import javax.persistence.Entity;

@Entity
// @Table(name = "CIRCLE_PERCLASS")
public class CirclePerclass extends ShapePerclass {

    private static final long serialVersionUID = 667923770892268408L;

    // @Column(name = "RADIUS")
    private Integer radius;

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + " / radius: " + radius;
    }

}
