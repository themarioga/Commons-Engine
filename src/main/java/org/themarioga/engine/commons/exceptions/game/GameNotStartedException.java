package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameNotStartedException extends ApplicationException {

    public GameNotStartedException() {
        super(CommonErrorEnum.GAME_NOT_STARTED);
    }

}
