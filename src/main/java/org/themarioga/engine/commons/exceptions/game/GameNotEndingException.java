package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameNotEndingException extends ApplicationException {

    public GameNotEndingException() {
        super(ErrorEnum.GAME_NOT_CONFIGURED);
    }

}
