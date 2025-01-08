package org.themarioga.game.commons.dao.intf;

import org.themarioga.game.commons.dao.InterfaceHibernateDao;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

public interface PlayerDao extends InterfaceHibernateDao<Player> {

    Player findPlayerByUser(User user);

}
