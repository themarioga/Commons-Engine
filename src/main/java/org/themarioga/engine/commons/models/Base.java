package org.themarioga.engine.commons.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Date creationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Base base = (Base) o;
		return getId().equals(base.getId()) && getCreationDate().equals(base.getCreationDate());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getCreationDate().hashCode();
		return result;
	}

}
