package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomDoesntExistsException extends ApplicationException {

    public RoomDoesntExistsException() {
        super(CommonErrorEnum.ROOM_NOT_FOUND);
    }

}
