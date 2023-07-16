package com.elte.fsz.takemybook.domain;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Obsolete {
    //poroperties
	@Id
	@GeneratedValue
	private Long id;
	private String description;
    private Date dateOfDeath;
    //constructors
    public Obsolete() {
    }
    //mutators, accessors
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

	@Override
	public int hashCode() {
		return Objects.hash(dateOfDeath, description, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Obsolete other = (Obsolete) obj;
		return Objects.equals(dateOfDeath, other.dateOfDeath) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id);
	}
}
