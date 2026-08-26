package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameCreatorCannotLeaveException extends ApplicationException {

    public GameCreatorCannotLeaveException() {
        super(CommonErrorEnum.GAME_CREATOR_CANNOT_LEAVE);
    }

}
