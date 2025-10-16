package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerAlreadyExistsException extends ApplicationException {

    public PlayerAlreadyExistsException() {
        super(ErrorEnum.PLAYER_ALREADY_EXISTS);
    }

}
