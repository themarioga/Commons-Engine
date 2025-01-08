package org.themarioga.game.commons.exceptions.player;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class PlayerAlreadyExistsException extends ApplicationException {

    public PlayerAlreadyExistsException() {
        super(ErrorEnum.PLAYER_ALREADY_EXISTS);
    }

}
