package org.themarioga.game.commons.exceptions.game;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class GameCreatorCannotLeaveException extends ApplicationException {

    public GameCreatorCannotLeaveException() {
        super(ErrorEnum.GAME_CREATOR_CANNOT_LEAVE);
    }

}
