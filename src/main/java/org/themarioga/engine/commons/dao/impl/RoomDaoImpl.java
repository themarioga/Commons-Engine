package org.themarioga.engine.commons.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.engine.commons.dao.AbstractHibernateDao;
import org.themarioga.engine.commons.dao.intf.RoomDao;
import org.themarioga.engine.commons.models.Room;

@Repository
public class RoomDaoImpl extends AbstractHibernateDao<Room> implements RoomDao {

    public RoomDaoImpl() {
        setClazz(Room.class);
    }

    @Override
    public Room getRoomName(String roomname) {
        return getCurrentSession().createQuery("SELECT r FROM Room r WHERE r.name LIKE :roomname", Room.class).setParameter("roomname", "%" + roomname + "%").getSingleResultOrNull();
    }

}
