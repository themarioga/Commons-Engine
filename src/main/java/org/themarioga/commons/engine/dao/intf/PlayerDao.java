package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.models.Game;
import org.themarioga.commons.engine.models.Player;
import org.themarioga.commons.engine.models.User;

public interface PlayerDao<P extends Player> {

    P findPlayerByUser(User user);

    P findPlayerByUserAndGame(User user, Game game);

}
