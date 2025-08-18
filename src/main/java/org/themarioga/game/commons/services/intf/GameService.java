package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.enums.GameStatusEnum;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Room;
import org.themarioga.game.commons.models.User;

import java.util.UUID;

public interface GameService<G extends Game> {

    G create(String roomName, User creator);

    void delete(G game);

    G setStatus(G game, GameStatusEnum gameStatusEnum);

    G addPlayer(G game, User user);

    G removePlayer(G game, User user);

    G startGame(G game);

    void endGame(G game);

    G voteForDeletion(G game, User user);

    G getByRoom(Room room);

    G getByRoomId(UUID roomId);

}
