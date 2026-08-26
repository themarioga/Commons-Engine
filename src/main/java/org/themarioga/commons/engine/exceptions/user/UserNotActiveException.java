package org.themarioga.commons.engine.exceptions.user;

import org.themarioga.commons.engine.enums.CommonErrorEnum;
import org.themarioga.commons.engine.exceptions.ApplicationException;

public class UserNotActiveException extends ApplicationException {

    public UserNotActiveException() {
        super(CommonErrorEnum.USER_NOT_ACTIVE);
    }

}
