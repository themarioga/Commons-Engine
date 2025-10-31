package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.models.Game;
import org.themarioga.engine.commons.models.Player;
import org.themarioga.engine.commons.models.User;

public interface PlayerDao {

	Player findPlayerByUser(User user);

	Player findPlayerByUserAndGame(User user, Game game);

}
