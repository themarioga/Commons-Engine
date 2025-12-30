package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomAlreadyExistsException extends ApplicationException {

    public RoomAlreadyExistsException() {
        super(CommonErrorEnum.ROOM_ALREADY_EXISTS);
    }

}
