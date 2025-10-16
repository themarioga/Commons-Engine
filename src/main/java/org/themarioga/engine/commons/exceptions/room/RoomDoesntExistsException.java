package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomDoesntExistsException extends ApplicationException {

    public RoomDoesntExistsException() {
        super(ErrorEnum.ROOM_NOT_FOUND);
    }

}
