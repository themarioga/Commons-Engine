package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerDoesntExistsException extends ApplicationException {

    public PlayerDoesntExistsException() {
        super(CommonErrorEnum.PLAYER_NOT_FOUND);
    }

}
