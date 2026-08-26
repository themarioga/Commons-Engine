package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameAlreadyStartedException extends ApplicationException {

    public GameAlreadyStartedException() {
        super(CommonErrorEnum.GAME_ALREADY_STARTED);
    }

}
