package biz.hahamo.dev.enterprise.example;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "CIRCLE")
public class Circle extends Shape {
	
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
