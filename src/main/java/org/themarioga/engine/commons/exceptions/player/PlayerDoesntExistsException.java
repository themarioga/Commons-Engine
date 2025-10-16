package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerDoesntExistsException extends ApplicationException {

    public PlayerDoesntExistsException() {
        super(ErrorEnum.PLAYER_NOT_FOUND);
    }

}
