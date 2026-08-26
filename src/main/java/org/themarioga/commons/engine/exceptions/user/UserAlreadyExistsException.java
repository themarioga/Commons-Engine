package org.themarioga.commons.engine.exceptions.user;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class UserAlreadyExistsException extends ApplicationException {

    public UserAlreadyExistsException() {
        super(CommonErrorEnum.USER_ALREADY_EXISTS);
    }

}
