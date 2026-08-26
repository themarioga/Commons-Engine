package org.themarioga.commons.engine.exceptions.player;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class PlayerDoesntExistsException extends ApplicationException {

    public PlayerDoesntExistsException() {
        super(CommonErrorEnum.PLAYER_NOT_FOUND);
    }

}
