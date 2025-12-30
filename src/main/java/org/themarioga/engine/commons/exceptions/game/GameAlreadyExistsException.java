package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyExistsException extends ApplicationException {

    public GameAlreadyExistsException() {
        super(CommonErrorEnum.GAME_ALREADY_EXISTS);
    }

}
