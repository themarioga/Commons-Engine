package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameCreatorAlreadyExistsException extends ApplicationException {

    public GameCreatorAlreadyExistsException() {
        super(ErrorEnum.GAME_ALREADY_EXISTS);
    }

}
