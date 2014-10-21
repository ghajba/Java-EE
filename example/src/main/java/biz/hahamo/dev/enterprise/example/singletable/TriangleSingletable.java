package biz.hahamo.dev.enterprise.example.singletable;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue("CircleSingletable") // won't work out: Hibernate throws an exception at startup
// @Table(name = "TRIANGLE_SINGLE")
public class TriangleSingletable extends ShapeSingletable {

    private static final long serialVersionUID = -1783113903772499963L;

    // @Column(name = "EQUAL_SITES")
    private Boolean equalSites;

    public Boolean getEqualSites() {
        return equalSites;
    }

    public void setEqualSites(Boolean equalSites) {
        this.equalSites = equalSites;
    }

    @Override
    public String toString() {
        return super.toString() + " / equalSites: " + equalSites;
    }
}
