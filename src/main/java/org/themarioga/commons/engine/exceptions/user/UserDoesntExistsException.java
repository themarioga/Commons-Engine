package org.themarioga.commons.engine.exceptions.user;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class UserDoesntExistsException extends ApplicationException {

    public UserDoesntExistsException() {
        super(CommonErrorEnum.USER_NOT_FOUND);
    }

}
