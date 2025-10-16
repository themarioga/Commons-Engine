package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameDoesntExistsException extends ApplicationException {

    public GameDoesntExistsException() {
        super(ErrorEnum.GAME_NOT_FOUND);
    }

}
