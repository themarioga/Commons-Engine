package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameAlreadyConfiguredException extends ApplicationException {

    public GameAlreadyConfiguredException() {
        super(CommonErrorEnum.GAME_ALREADY_CONFIGURED);
    }

}
