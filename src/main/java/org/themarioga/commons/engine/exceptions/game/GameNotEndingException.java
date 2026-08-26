package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameNotEndingException extends ApplicationException {

    public GameNotEndingException() {
        super(CommonErrorEnum.GAME_NOT_ENDING);
    }

}
