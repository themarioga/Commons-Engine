package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameCreatorCannotLeaveException extends ApplicationException {

    public GameCreatorCannotLeaveException() {
        super(ErrorEnum.GAME_CREATOR_CANNOT_LEAVE);
    }

}
