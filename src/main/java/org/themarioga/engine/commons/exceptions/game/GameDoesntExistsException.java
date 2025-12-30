package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameDoesntExistsException extends ApplicationException {

    public GameDoesntExistsException() {
        super(CommonErrorEnum.GAME_NOT_FOUND);
    }

}
