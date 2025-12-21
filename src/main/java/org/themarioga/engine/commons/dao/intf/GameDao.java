package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.models.Game;
import org.themarioga.engine.commons.models.Room;
import org.themarioga.engine.commons.models.User;

public interface GameDao<G extends Game> {

    G getByRoom(Room room);

    G getByCreator(User creator);

    Long countByRoom(Room room);

    Long countByCreator(User creator);

}
