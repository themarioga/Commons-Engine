package org.themarioga.commons.engine.exceptions.room;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class RoomAlreadyExistsException extends ApplicationException {

    public RoomAlreadyExistsException() {
        super(CommonErrorEnum.ROOM_ALREADY_EXISTS);
    }

}
