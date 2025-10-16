package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.models.Room;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    Room createOrReactivate(String name);

    Room rename(Room room, String newName);

    Room setActive(Room room, boolean active);

    Room getById(UUID id);

    Room getByName(String roomname);

    List<Room> getAllRooms();

}
