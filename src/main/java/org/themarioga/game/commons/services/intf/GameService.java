package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.enums.GameStatusEnum;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.Room;
import org.themarioga.game.commons.models.User;

import java.util.UUID;

public interface GameService<T extends Game> {

    T create(String roomName, User creator);

    T delete(T game);

    T setStatus(T game, GameStatusEnum gameStatusEnum);

    T addPlayer(T game, Player player);

    T removePlayer(T game, Player player);

    T startGame(T game);

    T endGame(T game);

    T voteForDeletion(T game, Player player);

    T getByRoom(Room room);

    T getByRoomId(UUID roomId);

}
