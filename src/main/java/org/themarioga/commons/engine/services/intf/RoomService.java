package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Room;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    Room createOrReactivate(String roomname, String name);

    Room rename(Room room, String newName);

    Room setActive(Room room, boolean active);

    Room getById(UUID id);

    Room getByRoomname(String roomname);

    List<Room> getAllRooms();

}
