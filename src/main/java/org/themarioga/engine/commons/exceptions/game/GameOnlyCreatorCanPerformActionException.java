package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameOnlyCreatorCanPerformActionException extends ApplicationException {

    public GameOnlyCreatorCanPerformActionException() {
        super(CommonErrorEnum.GAME_ONLY_CREATOR_CAN_PERFORM_ACTION);
    }

}
