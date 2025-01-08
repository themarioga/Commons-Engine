package org.themarioga.game.commons.exceptions.room;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class RoomNotActiveException extends ApplicationException {

    public RoomNotActiveException() {
        super(ErrorEnum.ROOM_NOT_ACTIVE);
    }

}
