package org.themarioga.engine.commons.exceptions.user;

import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class UserNotActiveException extends ApplicationException {

    public UserNotActiveException() {
        super(CommonErrorEnum.USER_NOT_ACTIVE);
    }

}
