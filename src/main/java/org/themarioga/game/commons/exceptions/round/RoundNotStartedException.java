package org.themarioga.game.commons.exceptions.round;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class RoundNotStartedException extends ApplicationException {

    public RoundNotStartedException() {
        super(ErrorEnum.ROUND_NOT_STARTED);
    }

}
