package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerAlreadyVotedDeleteException extends ApplicationException {

    public PlayerAlreadyVotedDeleteException() {
        super(ErrorEnum.PLAYER_ALREADY_VOTED_DELETION);
    }

}
