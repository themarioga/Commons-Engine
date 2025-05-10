package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.enums.GameStatusEnum;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.Room;
import org.themarioga.game.commons.models.User;

import java.util.UUID;

public interface GameService<G extends Game, P extends Player> {

    G create(String roomName, User creator);

    void delete(G game);

    G setStatus(G game, GameStatusEnum gameStatusEnum);

    G addPlayer(G game, P player);

    G removePlayer(G game, P player);

    G startGame(G game);

    void endGame(G game);

    G voteForDeletion(G game, P player);

    G getByRoom(Room room);

    G getByRoomId(UUID roomId);

}
