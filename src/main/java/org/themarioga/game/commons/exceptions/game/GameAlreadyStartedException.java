package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameAlreadyStartedException extends ApplicationException {

    public GameAlreadyStartedException() {
        super(ErrorEnum.GAME_ALREADY_STARTED);
    }

}
