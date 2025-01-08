package org.themarioga.game.commons.exceptions.room;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class RoomAlreadyExistsException extends ApplicationException {

    public RoomAlreadyExistsException() {
        super(ErrorEnum.ROOM_ALREADY_EXISTS);
    }

}
