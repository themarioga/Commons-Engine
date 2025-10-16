package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyConfiguredException extends ApplicationException {

    public GameAlreadyConfiguredException() {
        super(ErrorEnum.GAME_ALREADY_CONFIGURED);
    }

}
