package org.themarioga.commons.engine.exceptions.player;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class PlayerCannotVoteDeletionException extends ApplicationException {

    public PlayerCannotVoteDeletionException() {
        super(CommonErrorEnum.PLAYER_CANNOT_VOTE_DELETION);
    }

}
