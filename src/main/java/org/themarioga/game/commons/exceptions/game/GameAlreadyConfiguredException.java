package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameAlreadyConfiguredException extends ApplicationException {

    public GameAlreadyConfiguredException() {
        super(ErrorEnum.GAME_ALREADY_CONFIGURED);
    }

}
