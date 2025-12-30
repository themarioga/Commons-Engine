package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameNotEndingException extends ApplicationException {

    public GameNotEndingException() {
        super(CommonErrorEnum.GAME_NOT_CONFIGURED);
    }

}
