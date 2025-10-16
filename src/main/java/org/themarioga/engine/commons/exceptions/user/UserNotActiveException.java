package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserNotActiveException extends ApplicationException {

    public UserNotActiveException() {
        super(ErrorEnum.USER_NOT_ACTIVE);
    }

}
