package org.themarioga.engine.commons.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(indexes = {@Index(columnList = "name")})
public class Room extends Base {

    /**
     * Identidad de la sala: única, estable y agnóstica de la plataforma. En Telegram es
     * "tg:&lt;chatId&gt;" del grupo en el que se juega.
     */
    @Column(length = 128, nullable = false, unique = true)
    private String roomname;
    /**
     * Nombre visible de la sala: ni único ni estable (en Telegram, el título del grupo).
     */
    @Column(length = 256, nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean active;

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

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
        return "Room{id=" + getId() + ", roomname='" + roomname + '\'' + ", name='" + name + '\'' + ", active=" + active + '}';
    }

}
