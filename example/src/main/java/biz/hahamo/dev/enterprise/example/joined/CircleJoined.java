package biz.hahamo.dev.enterprise.example.joined;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue(value = "CIRCLE")
// @Table(name = "CIRCLE_JOINED")
public class CircleJoined extends ShapeJoined {

    private static final long serialVersionUID = 667923770892268408L;

    // @Column(name = "RADIUS")
    private Integer radius;

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
