package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyStartedException extends ApplicationException {

    public GameAlreadyStartedException() {
        super(ErrorEnum.GAME_ALREADY_STARTED);
    }

}
