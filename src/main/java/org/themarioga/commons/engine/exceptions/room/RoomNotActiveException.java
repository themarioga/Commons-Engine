package org.themarioga.commons.engine.exceptions.room;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class RoomNotActiveException extends ApplicationException {

    public RoomNotActiveException() {
        super(CommonErrorEnum.ROOM_NOT_ACTIVE);
    }

}
