package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameAlreadyConfiguredException extends ApplicationException {

    public GameAlreadyConfiguredException() {
        super(CommonErrorEnum.GAME_ALREADY_CONFIGURED);
    }

}
