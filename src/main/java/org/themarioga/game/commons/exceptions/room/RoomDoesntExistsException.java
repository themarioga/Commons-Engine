package org.themarioga.game.commons.exceptions.room;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class RoomDoesntExistsException extends ApplicationException {

    public RoomDoesntExistsException() {
        super(ErrorEnum.ROOM_NOT_FOUND);
    }

}
