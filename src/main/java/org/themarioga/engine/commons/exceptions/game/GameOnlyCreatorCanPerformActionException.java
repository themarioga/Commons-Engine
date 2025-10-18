package org.themarioga.engine.commons.exceptions.game;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class GameOnlyCreatorCanPerformActionException extends ApplicationException {

    public GameOnlyCreatorCanPerformActionException() {
        super(ErrorEnum.GAME_ONLY_CREATOR_CAN_PERFORM_ACTION);
    }

}
