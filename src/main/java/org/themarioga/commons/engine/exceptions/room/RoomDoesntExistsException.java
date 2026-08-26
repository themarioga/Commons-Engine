package org.themarioga.commons.engine.exceptions.room;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class RoomDoesntExistsException extends ApplicationException {

    public RoomDoesntExistsException() {
        super(CommonErrorEnum.ROOM_NOT_FOUND);
    }

}
