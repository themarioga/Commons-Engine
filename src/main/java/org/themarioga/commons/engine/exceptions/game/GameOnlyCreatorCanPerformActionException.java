package org.themarioga.commons.engine.exceptions.game;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class GameOnlyCreatorCanPerformActionException extends ApplicationException {

    public GameOnlyCreatorCanPerformActionException() {
        super(CommonErrorEnum.GAME_ONLY_CREATOR_CAN_PERFORM_ACTION);
    }

}
