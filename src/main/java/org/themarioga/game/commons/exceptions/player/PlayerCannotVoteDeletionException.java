package org.themarioga.game.commons.exceptions.player;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class PlayerCannotVoteDeletionException extends ApplicationException {

    public PlayerCannotVoteDeletionException() {
        super(ErrorEnum.PLAYER_CANNOT_VOTE_DELETION);
    }

}
