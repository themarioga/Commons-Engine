package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameAlreadyExistsException extends ApplicationException {

    public GameAlreadyExistsException() {
        super(ErrorEnum.GAME_ALREADY_EXISTS);
    }

}
