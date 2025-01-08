package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameNotYourException extends ApplicationException {

    public GameNotYourException() {
        super(ErrorEnum.USER_NOT_FOUND);
    }

}
