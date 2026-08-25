package org.themarioga.engine.commons.models;

import jakarta.persistence.*;
import org.themarioga.engine.commons.enums.GameStatusEnum;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "aGame")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Game extends Base {

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private GameStatusEnum status;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private Room room;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, unique = true)
    private User creator;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "game_deletion_votes", joinColumns = @JoinColumn(name = "game_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<User> deletionVotes = new ArrayList<>(0);

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

    public List<User> getDeletionVotes() {
        return deletionVotes;
    }

    public void setDeletionVotes(List<User> deletionVotes) {
        this.deletionVotes = deletionVotes;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + getId() + ", room=" + room + ", status=" + status + ", creator=" + creator + '}';
    }

}
