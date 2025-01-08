package org.themarioga.game.commons.exceptions.player;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class PlayerDoesntExistsException extends ApplicationException {

    public PlayerDoesntExistsException() {
        super(ErrorEnum.PLAYER_NOT_FOUND);
    }

}
