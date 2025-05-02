package org.themarioga.game.commons.models;

import jakarta.persistence.*;
import org.themarioga.game.commons.enums.GameStatusEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Game extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private GameStatusEnum status;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private Room room;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private User creator;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "game", orphanRemoval = true)
    private List<Player> players = new ArrayList<>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(nullable = false), inverseJoinColumns = @JoinColumn(name = "player_id", nullable = false))
    private List<Player> deletionVotes = new ArrayList<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameStatusEnum getStatus() {
        return status;
    }

    public void setStatus(GameStatusEnum currentStatus) {
        this.status = currentStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getDeletionVotes() {
        return deletionVotes;
    }

    public void setDeletionVotes(List<Player> deletionVotes) {
        this.deletionVotes = deletionVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;
        return getId().equals(game.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", room=" + room +
                ", status=" + status +
                ", creator=" + creator +
                '}';
    }

}
