package org.themarioga.game.commons.exceptions.player;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class PlayerAlreadyVotedDeleteException extends ApplicationException {

    public PlayerAlreadyVotedDeleteException() {
        super(ErrorEnum.PLAYER_ALREADY_VOTED_DELETION);
    }

}
