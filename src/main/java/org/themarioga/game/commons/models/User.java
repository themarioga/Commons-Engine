package org.themarioga.game.commons.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Users", indexes = {@Index(columnList = "name")})
public class User extends Base {

    @Column(length = 256, nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean active;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Lang lang;

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

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "User{id=" + getId() + ", name='" + name + '\'' + ", active=" + active + '}';
    }

}
