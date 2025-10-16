package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerCannotVoteDeletionException extends ApplicationException {

    public PlayerCannotVoteDeletionException() {
        super(ErrorEnum.PLAYER_CANNOT_VOTE_DELETION);
    }

}
