package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.enums.GameStatusEnum;
import org.themarioga.commons.engine.models.Game;
import org.themarioga.commons.engine.models.Player;
import org.themarioga.commons.engine.models.Room;
import org.themarioga.commons.engine.models.User;

public interface GameService<G extends Game, P extends Player> {

    G create(Room room, User creator);

    G update(G game);

    void delete(G game);

    G setMaxNumberOfPlayers(G game, int maxNumberOfPlayers);

    G setStatus(G game, GameStatusEnum gameStatusEnum);

    G addPlayer(G game, P player);

    G removePlayer(G game, P player);

    G startGame(G game);

    void endGame(G game);

    G voteForDeletion(G game, P player);

    G getByRoom(Room room);

}
