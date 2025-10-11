package org.themarioga.game.commons.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "aPlayer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Player extends Base implements Serializable {

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Game game;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, unique = true)
	private User user;

	@Column(nullable = false)
	private Integer joinOrder;

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

	public Integer getJoinOrder() {
		return joinOrder;
	}

	public void setJoinOrder(Integer joinOrder) {
		this.joinOrder = joinOrder;
	}

	@Override
	public String toString() {
		return "Player{" +
				"game=" + game +
				", user=" + user +
				", joinOrder=" + joinOrder +
				'}';
	}

}