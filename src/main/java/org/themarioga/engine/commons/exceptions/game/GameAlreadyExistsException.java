package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyExistsException extends ApplicationException {

    public GameAlreadyExistsException() {
        super(ErrorEnum.GAME_ALREADY_EXISTS);
    }

}
