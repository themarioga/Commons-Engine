package org.themarioga.game.commons.dao.intf;

import org.themarioga.game.commons.dao.InterfaceHibernateDao;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Room;
import org.themarioga.game.commons.models.User;

public interface GameDao extends InterfaceHibernateDao<Game> {

    Game getByRoom(Room room);

    Game getByCreator(User creator);

    Long countByRoom(Room room);

    Long countByCreator(User creator);
}
