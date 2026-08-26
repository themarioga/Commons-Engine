package org.themarioga.engine.commons.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Users", indexes = {@Index(columnList = "name")})
public class User extends Base {

    /**
     * Identidad del usuario: única, estable y agnóstica de la plataforma. En Telegram es el alias
     * (en minúsculas, sin la '@') o "tg:&lt;telegramId&gt;" cuando el usuario no tiene alias.
     */
    @Column(length = 64, nullable = false, unique = true)
    private String username;
    /**
     * Nombre visible del usuario: ni único ni estable, solo para mostrar en los mensajes.
     */
    @Column(length = 256, nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean active;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Lang lang;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "User{id=" + getId() + ", username='" + username + '\'' + ", name='" + name + '\'' + ", active=" + active + '}';
    }

}
