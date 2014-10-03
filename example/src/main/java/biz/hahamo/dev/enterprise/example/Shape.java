package biz.hahamo.dev.enterprise.example;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE")
public abstract class Shape implements Serializable {
	
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
