package org.themarioga.commons.engine.exceptions.player;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class PlayerAlreadyExistsException extends ApplicationException {

    public PlayerAlreadyExistsException() {
        super(CommonErrorEnum.PLAYER_ALREADY_EXISTS);
    }

}
