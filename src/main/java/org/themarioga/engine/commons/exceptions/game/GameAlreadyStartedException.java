package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyStartedException extends ApplicationException {

    public GameAlreadyStartedException() {
        super(CommonErrorEnum.GAME_ALREADY_STARTED);
    }

}
