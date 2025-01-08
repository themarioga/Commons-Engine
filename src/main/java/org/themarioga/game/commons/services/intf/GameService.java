package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.enums.GameStatusEnum;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.Room;

public interface GameService {

    Game create(long roomId, String roomName, long creatorId);

    Game delete(Game game);

    Game setStatus(Game game, GameStatusEnum gameStatusEnum);

    Game addPlayer(Game game, Player player);

    Game removePlayer(Game game, Player player);

    Game startGame(Game game);

    Game endGame(Game game);

    Game voteForDeletion(Game game, long userId);

    Game getByRoom(Room room);

    Game getByRoomId(long roomId);

}
