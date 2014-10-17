package biz.hahamo.dev.enterprise.example.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("TRIANGLE")
// @Table(name = "TRIANGLE_SINGLETABLE")
public class TriangleSingletable extends ShapeSingletable {

    private static final long serialVersionUID = -1783113903772499963L;

    @Column(name = "EQUAL_SITES")
    private Boolean equalSites;

    public Boolean getEqualSites() {
        return equalSites;
    }

    public void setEqualSites(Boolean equalSites) {
        this.equalSites = equalSites;
    }

}
