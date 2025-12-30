package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerCannotVoteDeletionException extends ApplicationException {

    public PlayerCannotVoteDeletionException() {
        super(CommonErrorEnum.PLAYER_CANNOT_VOTE_DELETION);
    }

}
