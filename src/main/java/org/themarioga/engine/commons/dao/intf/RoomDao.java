package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.dao.InterfaceHibernateDao;
import org.themarioga.engine.commons.models.Room;

public interface RoomDao extends InterfaceHibernateDao<Room> {

    Room getByRoomname(String roomname);

}
