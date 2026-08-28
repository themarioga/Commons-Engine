package org.themarioga.commons.engine.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.commons.engine.dao.intf.RoomDao;
import org.themarioga.commons.engine.exceptions.room.RoomAlreadyExistsException;
import org.themarioga.commons.engine.exceptions.room.RoomDoesntExistsException;
import org.themarioga.commons.engine.exceptions.room.RoomNotActiveException;
import org.themarioga.commons.engine.models.Room;
import org.themarioga.commons.engine.services.impl.RoomServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @InjectMocks
    RoomServiceImpl roomService;

    @Mock
    RoomDao roomDao;

    private Room activeRoom;
    private Room inactiveRoom;

    @BeforeEach
    void setUp() {
        activeRoom = new Room();
        activeRoom.setId(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        activeRoom.setRoomname("tg:-100001");
        activeRoom.setName("First");
        activeRoom.setActive(true);

        inactiveRoom = new Room();
        inactiveRoom.setId(UUID.fromString("22222222-2222-2222-2222-222222222222"));
        inactiveRoom.setRoomname("tg:-100003");
        inactiveRoom.setName("Third");
        inactiveRoom.setActive(false);
    }

    @Test
    void testCreateOrReactivate() {
        when(roomDao.getByRoomname("tg:-100002")).thenReturn(null);
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> {
            Room r = invocation.getArgument(0);
            r.setId(UUID.randomUUID());
            return r;
        });

        Room room = roomService.createOrReactivate("tg:-100002", "Test");

        Assertions.assertNotNull(room);
        Assertions.assertNotNull(room.getId());
        Assertions.assertEquals("tg:-100002", room.getRoomname());
        Assertions.assertEquals("Test", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_Reactivate() {
        when(roomDao.getByRoomname("tg:-100003")).thenReturn(inactiveRoom);
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Room room = roomService.createOrReactivate("tg:-100003", "Third renombrada");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), room.getId());
        Assertions.assertEquals("tg:-100003", room.getRoomname());
        Assertions.assertEquals("Third renombrada", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_AlreadyActive() {
        when(roomDao.getByRoomname("tg:-100001")).thenReturn(activeRoom);

        Assertions.assertThrows(RoomAlreadyExistsException.class, () -> roomService.createOrReactivate("tg:-100001", "First"));
    }

    /**
     * Dos grupos de Telegram pueden llamarse igual: el nombre visible ya no es identidad, así que
     * crear una sala con un nombre repetido pero distinto roomname debe funcionar.
     */
    @Test
    void testCreateOrReactivate_DuplicatedNameIsAllowed() {
        when(roomDao.getByRoomname("tg:-100099")).thenReturn(null);
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> {
            Room r = invocation.getArgument(0);
            r.setId(UUID.randomUUID());
            return r;
        });

        Room room = roomService.createOrReactivate("tg:-100099", "First");

        Assertions.assertNotNull(room);
        Assertions.assertEquals("tg:-100099", room.getRoomname());
        Assertions.assertEquals("First", room.getName());
    }

    @Test
    void testRename() {
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Room room = roomService.rename(activeRoom, "Newname");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("Newname", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testSetActive() {
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Room room = roomService.setActive(inactiveRoom, true);

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), room.getId());
        Assertions.assertEquals("Third", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetById() {
        when(roomDao.findOne(activeRoom.getId())).thenReturn(activeRoom);

        Room room = roomService.getById(activeRoom.getId());

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetById_NonExistant() {
        when(roomDao.findOne(any())).thenReturn(null);
        Assertions.assertThrows(RoomDoesntExistsException.class, () -> roomService.getById(UUID.fromString("00000000-0000-0000-0000-000000000001")));
    }

    @Test
    void testGetById_NotActive() {
        when(roomDao.findOne(inactiveRoom.getId())).thenReturn(inactiveRoom);
        Assertions.assertThrows(RoomNotActiveException.class, () -> roomService.getById(inactiveRoom.getId()));
    }

    @Test
    void testGetByRoomname() {
        when(roomDao.getByRoomname("tg:-100001")).thenReturn(activeRoom);

        Room room = roomService.getByRoomname("tg:-100001");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetByRoomname_NonExistant() {
        when(roomDao.getByRoomname("tg:-100404")).thenReturn(null);
        Assertions.assertThrows(RoomDoesntExistsException.class, () -> roomService.getByRoomname("tg:-100404"));
    }

    @Test
    void testGetByRoomname_NotActive() {
        when(roomDao.getByRoomname("tg:-100003")).thenReturn(inactiveRoom);
        Assertions.assertThrows(RoomNotActiveException.class, () -> roomService.getByRoomname("tg:-100003"));
    }

}
