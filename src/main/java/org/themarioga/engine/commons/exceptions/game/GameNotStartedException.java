package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameNotStartedException extends ApplicationException {

    public GameNotStartedException() {
        super(ErrorEnum.GAME_NOT_CONFIGURED);
    }

}
