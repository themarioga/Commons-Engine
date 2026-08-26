package org.themarioga.commons.engine.exceptions.player;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class PlayerAlreadyVotedDeleteException extends ApplicationException {

    public PlayerAlreadyVotedDeleteException() {
        super(CommonErrorEnum.PLAYER_ALREADY_VOTED_DELETION);
    }

}
