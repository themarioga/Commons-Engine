package org.themarioga.game.commons.exceptions.user;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class UserDoesntExistsException extends ApplicationException {

    public UserDoesntExistsException() {
        super(ErrorEnum.USER_NOT_FOUND);
    }

}
