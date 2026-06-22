package org.themarioga.engine.commons.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.dao.intf.RoomDao;
import org.themarioga.engine.commons.exceptions.room.RoomAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomDoesntExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomNotActiveException;
import org.themarioga.engine.commons.models.Room;
import org.themarioga.engine.commons.services.impl.RoomServiceImpl;

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
        activeRoom.setName("First");
        activeRoom.setActive(true);

        inactiveRoom = new Room();
        inactiveRoom.setId(UUID.fromString("22222222-2222-2222-2222-222222222222"));
        inactiveRoom.setName("Third");
        inactiveRoom.setActive(false);
    }

    @Test
    void testCreateOrReactivate() {
        when(roomDao.getRoomName("Test")).thenReturn(null);
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> {
            Room r = invocation.getArgument(0);
            r.setId(UUID.randomUUID());
            return r;
        });

        Room room = roomService.createOrReactivate("Test");

        Assertions.assertNotNull(room);
        Assertions.assertNotNull(room.getId());
        Assertions.assertEquals("Test", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_Reactivate() {
        when(roomDao.getRoomName("Third")).thenReturn(inactiveRoom);
        when(roomDao.createOrUpdate(any(Room.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Room room = roomService.createOrReactivate("Third");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), room.getId());
        Assertions.assertEquals("Third", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testCreateOrReactivate_AlreadyActive() {
        when(roomDao.getRoomName("First")).thenReturn(activeRoom);

        Assertions.assertThrows(RoomAlreadyExistsException.class, () -> roomService.createOrReactivate("First"));
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
    void testGetByName() {
        when(roomDao.getRoomName("First")).thenReturn(activeRoom);

        Room room = roomService.getByName("First");

        Assertions.assertNotNull(room);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void testGetByName_NonExistant() {
        when(roomDao.getRoomName("Hello")).thenReturn(null);
        Assertions.assertThrows(RoomDoesntExistsException.class, () -> roomService.getByName("Hello"));
    }

    @Test
    void testGetByName_NotActive() {
        when(roomDao.getRoomName("Third")).thenReturn(inactiveRoom);
        Assertions.assertThrows(RoomNotActiveException.class, () -> roomService.getByName("Third"));
    }

}
