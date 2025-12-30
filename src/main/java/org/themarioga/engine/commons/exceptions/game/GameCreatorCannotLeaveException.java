package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameCreatorCannotLeaveException extends ApplicationException {

    public GameCreatorCannotLeaveException() {
        super(CommonErrorEnum.GAME_CREATOR_CANNOT_LEAVE);
    }

}
