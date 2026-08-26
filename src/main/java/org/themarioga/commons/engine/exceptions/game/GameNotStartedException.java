package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameNotStartedException extends ApplicationException {

    public GameNotStartedException() {
        super(CommonErrorEnum.GAME_NOT_STARTED);
    }

}
