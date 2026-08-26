package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.dao.InterfaceHibernateDao;
import org.themarioga.commons.engine.models.Room;

public interface RoomDao extends InterfaceHibernateDao<Room> {

    Room getByRoomname(String roomname);

}
