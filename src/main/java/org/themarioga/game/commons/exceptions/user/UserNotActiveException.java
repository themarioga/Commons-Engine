package org.themarioga.game.commons.exceptions.user;

import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;

public class UserNotActiveException extends ApplicationException {

    public UserNotActiveException() {
        super(ErrorEnum.USER_NOT_ACTIVE);
    }

}
