package org.themarioga.game.commons.models;

import jakarta.persistence.*;

@Entity(name = "aPlayer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Player extends Base {

    @Column(nullable = false)
    private Integer joinOrder;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Game game;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private User user;

    public Integer getJoinOrder() {
        return joinOrder;
    }

    public void setJoinOrder(Integer joinOrder) {
        this.joinOrder = joinOrder;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return getId().equals(player.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Player{" + "game=" + game + ", id=" + getId() + ", joinOrder=" + joinOrder + ", user=" + user + '}';
    }

}
