package org.themarioga.engine.commons.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.Base;
import org.themarioga.engine.commons.dao.intf.RoomDao;
import org.themarioga.engine.commons.models.Room;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@DatabaseSetup("classpath:dbunit/dao/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/dao/setup/room.xml")
class RoomDaoTest extends Base {

    @Autowired
    private RoomDao roomDao;

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/dao/expected/room/testCreateRoom-expected.xml", table = "Room", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void createRoom() {
        Room room = new Room();
        room.setName("Test room");
        room.setActive(true);
        room.setCreationDate(new Date());

        room = roomDao.createOrUpdate(room);
        getCurrentSession().flush();

        Assertions.assertNotNull(room.getId());
        Assertions.assertEquals("Test room", room.getName());
    }

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/dao/expected/room/testUpdateRoom-expected.xml", table = "Room", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void updateRoom() {
        Room room = roomDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        room.setName("Otro nombre");
        room.setActive(false);

        roomDao.createOrUpdate(room);
        getCurrentSession().flush();

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("Otro nombre", room.getName());
    }

    @Test
    void deleteRoom() {
        Room room = roomDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        roomDao.delete(room);
        getCurrentSession().flush();

        long total = roomDao.countAll();

        Assertions.assertEquals(0, total);
    }

    @Test
    void findRoom() {
        Room room = roomDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), room.getId());
        Assertions.assertEquals("First", room.getName());
        Assertions.assertEquals(true, room.getActive());
    }

    @Test
    void findAllRooms() {
        List<Room> rooms = roomDao.findAll();

        Assertions.assertEquals(1, rooms.size());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), rooms.get(0).getId());
        Assertions.assertEquals("First", rooms.get(0).getName());
        Assertions.assertEquals(true, rooms.get(0).getActive());
    }

    @Test
    void countAllRooms() {
        long total = roomDao.countAll();

        Assertions.assertEquals(1, total);
    }

}
