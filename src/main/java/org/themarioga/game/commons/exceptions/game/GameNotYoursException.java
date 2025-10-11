package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameNotYoursException extends ApplicationException {

    public GameNotYoursException() {
        super(ErrorEnum.USER_NOT_FOUND);
    }

}
