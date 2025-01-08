package org.themarioga.game.commons.exceptions.user;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class UserAlreadyExistsException extends ApplicationException {

    public UserAlreadyExistsException() {
        super(ErrorEnum.USER_ALREADY_EXISTS);
    }

}
