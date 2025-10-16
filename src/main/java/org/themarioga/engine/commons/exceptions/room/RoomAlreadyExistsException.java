package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomAlreadyExistsException extends ApplicationException {

    public RoomAlreadyExistsException() {
        super(ErrorEnum.ROOM_ALREADY_EXISTS);
    }

}
