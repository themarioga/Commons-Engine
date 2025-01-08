package org.themarioga.game.commons.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.game.commons.dao.AbstractHibernateDao;
import org.themarioga.game.commons.dao.intf.RoomDao;
import org.themarioga.game.commons.models.Room;

@Repository
public class RoomDaoImpl extends AbstractHibernateDao<Room> implements RoomDao {

    public RoomDaoImpl() {
        setClazz(Room.class);
    }

}
