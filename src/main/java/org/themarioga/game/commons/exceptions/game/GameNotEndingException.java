package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameNotEndingException extends ApplicationException {

    public GameNotEndingException() {
        super(ErrorEnum.GAME_NOT_CONFIGURED);
    }

}
