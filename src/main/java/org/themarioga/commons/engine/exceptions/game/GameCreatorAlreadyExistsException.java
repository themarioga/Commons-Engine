package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameCreatorAlreadyExistsException extends ApplicationException {

    public GameCreatorAlreadyExistsException() {
        super(CommonErrorEnum.GAME_CREATOR_ALREADY_EXISTS);
    }

}
