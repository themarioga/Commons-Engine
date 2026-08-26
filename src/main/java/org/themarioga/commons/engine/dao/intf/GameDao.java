package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.models.Game;
import org.themarioga.commons.engine.models.Room;
import org.themarioga.commons.engine.models.User;

public interface GameDao<G extends Game> {

    G getByRoom(Room room);

    G getByCreator(User creator);

    Long countByRoom(Room room);

    Long countByCreator(User creator);

}
