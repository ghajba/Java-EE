package biz.hahamo.dev.enterprise.example.singletable;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue("TRIANGLE")
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

}
