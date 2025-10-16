package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserDoesntExistsException extends ApplicationException {

    public UserDoesntExistsException() {
        super(ErrorEnum.USER_NOT_FOUND);
    }

}
