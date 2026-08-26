package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameDoesntExistsException extends ApplicationException {

    public GameDoesntExistsException() {
        super(CommonErrorEnum.GAME_NOT_FOUND);
    }

}
