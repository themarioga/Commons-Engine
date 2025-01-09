package org.themarioga.game.commons.dao.intf;

import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

public interface PlayerDao {

    Player findPlayerByUser(User user);

}
