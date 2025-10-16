package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameNotYoursException extends ApplicationException {

    public GameNotYoursException() {
        super(ErrorEnum.USER_NOT_FOUND);
    }

}
