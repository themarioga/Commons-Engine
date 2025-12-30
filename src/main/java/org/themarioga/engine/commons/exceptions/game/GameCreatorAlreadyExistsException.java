package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameCreatorAlreadyExistsException extends ApplicationException {

    public GameCreatorAlreadyExistsException() {
        super(CommonErrorEnum.GAME_ALREADY_EXISTS);
    }

}
