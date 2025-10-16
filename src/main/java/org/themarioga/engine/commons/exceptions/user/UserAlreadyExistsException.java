package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserAlreadyExistsException extends ApplicationException {

    public UserAlreadyExistsException() {
        super(ErrorEnum.USER_ALREADY_EXISTS);
    }

}
