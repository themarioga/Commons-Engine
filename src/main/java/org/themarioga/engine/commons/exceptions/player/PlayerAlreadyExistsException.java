package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerAlreadyExistsException extends ApplicationException {

    public PlayerAlreadyExistsException() {
        super(CommonErrorEnum.PLAYER_ALREADY_EXISTS);
    }

}
