package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameAlreadyExistsException extends ApplicationException {

    public GameAlreadyExistsException() {
        super(CommonErrorEnum.GAME_ALREADY_EXISTS);
    }

}
