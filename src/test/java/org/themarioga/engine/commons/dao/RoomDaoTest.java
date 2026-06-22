package org.themarioga.engine.commons.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.dao.impl.RoomDaoImpl;
import org.themarioga.engine.commons.models.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomDaoTest {

    @InjectMocks
    private RoomDaoImpl roomDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room();
        room.setId(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        room.setName("First");
        room.setActive(true);
    }

    @Test
    void createRoom() {
        when(entityManager.merge(any(Room.class))).thenReturn(room);

        Room newRoom = new Room();
        newRoom.setName("Test room");
        newRoom.setActive(true);
        newRoom.setCreationDate(new Date());

        Room createdRoom = roomDao.createOrUpdate(newRoom);

        Assertions.assertNotNull(createdRoom.getId());
        Assertions.assertEquals("First", createdRoom.getName());
        verify(entityManager).merge(newRoom);
    }

    @Test
    void updateRoom() {
        when(entityManager.merge(any(Room.class))).thenReturn(room);

        room.setName("Otro nombre");
        room.setActive(false);

        Room updatedRoom = roomDao.createOrUpdate(room);

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), updatedRoom.getId());
        Assertions.assertEquals("Otro nombre", updatedRoom.getName());
        verify(entityManager).merge(room);
    }

    @Test
    void deleteRoom() {
        doNothing().when(entityManager).remove(room);

        roomDao.delete(room);

        verify(entityManager).remove(room);
    }

    @Test
    void findRoom() {
        when(entityManager.find(Room.class, room.getId())).thenReturn(room);

        Room foundRoom = roomDao.findOne(room.getId());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), foundRoom.getId());
        Assertions.assertEquals("First", foundRoom.getName());
        Assertions.assertEquals(true, foundRoom.getActive());
    }

    @Test
    @SuppressWarnings("unchecked")
    void findAllRooms() {
        List<Room> list = new ArrayList<>();
        list.add(room);

        TypedQuery<Room> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Room.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(list);

        List<Room> rooms = roomDao.findAll();

        Assertions.assertEquals(1, rooms.size());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), rooms.get(0).getId());
        Assertions.assertEquals("First", rooms.get(0).getName());
        Assertions.assertEquals(true, rooms.get(0).getActive());
    }

    @Test
    @SuppressWarnings("unchecked")
    void countAllRooms() {
        TypedQuery<Room> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Room.class))).thenReturn(typedQuery);
        when(typedQuery.getResultStream()).thenReturn(Stream.of(room));

        long total = roomDao.countAll();

        Assertions.assertEquals(1, total);
    }

    @Test
    @SuppressWarnings("unchecked")
    void getRoomName() {
        Query<Room> query = mock(Query.class);
        when(entityManager.unwrap(Session.class)).thenReturn(session);
        when(session.createQuery(anyString(), eq(Room.class))).thenReturn(query);
        when(query.setParameter(anyString(), anyString())).thenReturn(query);
        when(query.getSingleResultOrNull()).thenReturn(room);

        Room foundRoom = roomDao.getRoomName("First");
        Assertions.assertNotNull(foundRoom);
        Assertions.assertEquals("First", foundRoom.getName());
    }

}
