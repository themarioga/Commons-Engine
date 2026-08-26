package org.themarioga.commons.engine.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

    // Null-safe a propósito: una entidad recién creada todavía no tiene id ni fecha, y comparar o
    // meter en un Set una entidad sin persistir no puede reventar con NullPointerException.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Base base = (Base) o;
        return Objects.equals(getId(), base.getId()) && Objects.equals(getCreationDate(), base.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreationDate());
    }

}
