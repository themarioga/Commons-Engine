package org.themarioga.engine.commons.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.BaseTest;
import org.themarioga.engine.commons.exceptions.room.RoomAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomDoesntExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomNotActiveException;
import org.themarioga.engine.commons.models.Room;
import org.themarioga.engine.commons.services.intf.RoomService;

import java.util.List;
import java.util.UUID;

@DatabaseSetup("classpath:dbunit/service/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/service/setup/user.xml")
@DatabaseSetup("classpath:dbunit/service/setup/room.xml")
class RoomServiceTest extends BaseTest {

    @Autowired
    RoomService roomService;

    @Test
    void testCreateOrReactivate() {
        Room room = roomService.createOrReactivate("Test");

        Assertions.assertNotNull(room);
        Assertions.assertNotNull(room.getId());
        Assertions.assertEquals("Test", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_Reactivate() {
        Room room = roomService.createOrReactivate("Third");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), room.getId());
        Assertions.assertEquals("Third", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_AlreadyActive() {
        Assertions.assertThrows(RoomAlreadyExistsException.class, () -> roomService.createOrReactivate("First"));
    }

    @Test
    void testRename() {
        Room room = roomService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        roomService.rename(room, "Newname");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("Newname", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testSetActive() {
        List<Room> roomList = roomService.getAllRooms();

        Room room = roomService.setActive(roomList.get(2), true);

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), room.getId());
        Assertions.assertEquals("Third", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetById() {
        Room room = roomService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetById_NonExistant() {
        Assertions.assertThrows(RoomDoesntExistsException.class, () -> roomService.getById(UUID.fromString("00000000-0000-0000-0000-000000000001")));
    }

    @Test
    void testGetById_NotActive() {
        Assertions.assertThrows(RoomNotActiveException.class, () -> roomService.getById(UUID.fromString("22222222-2222-2222-2222-222222222222")));
    }

    @Test
    void testGetByName() {
        Room room = roomService.getByName("First");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetByName_NonExistant() {
        Assertions.assertThrows(RoomDoesntExistsException.class, () -> roomService.getByName("Hello"));
    }

    @Test
    void testGetByName_NotActive() {
        Assertions.assertThrows(RoomNotActiveException.class, () -> roomService.getByName("Third"));
    }

}
