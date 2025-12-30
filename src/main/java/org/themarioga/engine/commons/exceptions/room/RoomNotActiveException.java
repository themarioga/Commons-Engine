package org.themarioga.engine.commons.exceptions.room;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class RoomNotActiveException extends ApplicationException {

    public RoomNotActiveException() {
        super(CommonErrorEnum.ROOM_NOT_ACTIVE);
    }

}
