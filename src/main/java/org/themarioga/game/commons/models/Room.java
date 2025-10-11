package org.themarioga.game.commons.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(indexes = {@Index(columnList = "name")})
public class Room extends Base {

    @Column(length = 256, nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Room{id=" + getName() + ", name='" + name + '\'' + ", active=" + active + '}';
    }

}
