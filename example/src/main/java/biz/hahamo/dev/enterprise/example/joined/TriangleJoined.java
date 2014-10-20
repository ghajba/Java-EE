package biz.hahamo.dev.enterprise.example.joined;

import javax.persistence.Entity;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorValue("TRIANGLE")
// @Table(name = "TRIANGLE_JOINED")
public class TriangleJoined extends ShapeJoined {

    private static final long serialVersionUID = -1783113903772499963L;

    // @Column(name = "EQUAL_SITES")
    private Boolean equalSites;

    public Boolean getEqualSites() {
        return equalSites;
    }

    public void setEqualSites(Boolean equalSites) {
        this.equalSites = equalSites;
    }

}
