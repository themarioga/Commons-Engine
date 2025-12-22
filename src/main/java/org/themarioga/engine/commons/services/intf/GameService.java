package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.enums.GameStatusEnum;
import org.themarioga.engine.commons.models.Game;
import org.themarioga.engine.commons.models.Player;
import org.themarioga.engine.commons.models.Room;
import org.themarioga.engine.commons.models.User;

public interface GameService<G extends Game, P extends Player> {

    G create(Room room, User creator);

    G update(G game);

    void delete(G game);

    G setStatus(G game, GameStatusEnum gameStatusEnum);

    G addPlayer(G game, P player);

    G removePlayer(G game, P player);

    G startGame(G game);

    void endGame(G game);

    G voteForDeletion(G game, P player);

    G getByRoom(Room room);

}
