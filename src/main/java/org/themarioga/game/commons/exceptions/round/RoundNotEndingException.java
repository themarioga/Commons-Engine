package org.themarioga.game.commons.exceptions.round;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class RoundNotEndingException extends ApplicationException {

    public RoundNotEndingException() {
        super(ErrorEnum.ROUND_NOT_ENDING);
    }

}
