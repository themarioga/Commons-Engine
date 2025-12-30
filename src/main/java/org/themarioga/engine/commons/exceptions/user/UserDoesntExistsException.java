package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserDoesntExistsException extends ApplicationException {

    public UserDoesntExistsException() {
        super(CommonErrorEnum.USER_NOT_FOUND);
    }

}
