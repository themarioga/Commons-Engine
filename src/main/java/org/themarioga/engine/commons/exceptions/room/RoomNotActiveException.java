package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomNotActiveException extends ApplicationException {

    public RoomNotActiveException() {
        super(ErrorEnum.ROOM_NOT_ACTIVE);
    }

}
