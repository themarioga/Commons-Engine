package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameDoesntExistsException extends ApplicationException {

    public GameDoesntExistsException() {
        super(ErrorEnum.GAME_NOT_FOUND);
    }

}
