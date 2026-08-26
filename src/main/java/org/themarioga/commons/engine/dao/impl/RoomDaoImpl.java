package org.themarioga.commons.engine.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.commons.engine.dao.AbstractHibernateDao;
import org.themarioga.commons.engine.dao.intf.RoomDao;
import org.themarioga.commons.engine.models.Room;

@Repository
public class RoomDaoImpl extends AbstractHibernateDao<Room> implements RoomDao {

    public RoomDaoImpl() {
        setClazz(Room.class);
    }

    @Override
    public Room getByRoomname(String roomname) {
        return getCurrentSession().createQuery("SELECT r FROM Room r WHERE r.roomname = :roomname", Room.class).setParameter("roomname", roomname).getSingleResultOrNull();
    }

}
