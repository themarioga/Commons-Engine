package org.themarioga.engine.commons.exceptions.player;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class PlayerAlreadyVotedDeleteException extends ApplicationException {

    public PlayerAlreadyVotedDeleteException() {
        super(CommonErrorEnum.PLAYER_ALREADY_VOTED_DELETION);
    }

}
