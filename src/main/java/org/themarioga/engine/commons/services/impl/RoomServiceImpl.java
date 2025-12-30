package org.themarioga.engine.commons.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.engine.commons.dao.intf.RoomDao;
import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;
import org.themarioga.engine.commons.exceptions.room.RoomAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomDoesntExistsException;
import org.themarioga.engine.commons.exceptions.room.RoomNotActiveException;
import org.themarioga.engine.commons.models.Room;
import org.themarioga.engine.commons.services.intf.RoomService;
import org.themarioga.engine.commons.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    private final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public Room createOrReactivate(String name) {
        logger.debug("Creating or reactivating room: {}", name);

        Assert.assertNotEmpty(name, CommonErrorEnum.ROOM_NAME_EMPTY);

        Room roomFromBd = roomDao.getRoomName(name);
        if (roomFromBd == null) {
            Room room = new Room();
            room.setName(name);
            room.setActive(true);
            room.setCreationDate(new Date());

            return roomDao.createOrUpdate(room);
        } else {
            if (Boolean.FALSE.equals(roomFromBd.getActive())) {
                roomFromBd.setName(name);
                roomFromBd.setActive(true);
                return roomDao.createOrUpdate(roomFromBd);
            } else {
                logger.error("Error trying to create room {}: Already exists", name);
                throw new RoomAlreadyExistsException();
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public Room rename(Room room, String newName) {
        logger.debug("Renaming user with ID {} to {}", room.getId(), newName);

        room.setName(newName);

        return roomDao.createOrUpdate(room);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public Room setActive(Room room, boolean active) {
        logger.debug("Activating/Deactivating room with ID {} to {}", room.getId(), active);

        room.setActive(active);

        return roomDao.createOrUpdate(room);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Room getById(UUID id) {
        logger.debug("Getting room with ID: {}", id);

        Room room = roomDao.findOne(id);
        if (room == null) {
            logger.error("Error getting room with id {}: Doesn't exists.", id);
            throw new RoomDoesntExistsException();
        }
        if (Boolean.FALSE.equals(room.getActive())) {
            logger.error("Error getting room with id {}: Not active.", id);
            throw new RoomNotActiveException();
        }

        return room;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Room getByName(String roomname) {
        logger.debug("Getting room with name {}", roomname);

        Room room = roomDao.getRoomName(roomname);
        if (room == null) {
            logger.error("Error getting room with roomname {}: Doesn't exists.", roomname);
            throw new RoomDoesntExistsException();
        }
        if (Boolean.FALSE.equals(room.getActive())) {
            logger.error("Error getting room with roomname {}: Not active.", roomname);
            throw new RoomNotActiveException();
        }

        return room;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Room> getAllRooms() {
        logger.debug("Getting all rooms");

        return roomDao.findAll();
    }

}
