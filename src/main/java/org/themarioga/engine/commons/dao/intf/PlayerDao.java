package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.models.Game;
import org.themarioga.engine.commons.models.Player;
import org.themarioga.engine.commons.models.User;

public interface PlayerDao<P extends Player> {

    P findPlayerByUser(User user);

    P findPlayerByUserAndGame(User user, Game game);

}
