package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserAlreadyExistsException extends ApplicationException {

    public UserAlreadyExistsException() {
        super(CommonErrorEnum.USER_ALREADY_EXISTS);
    }

}
