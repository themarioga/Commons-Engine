package org.themarioga.engine.commons.util;

import org.themarioga.engine.commons.enums.ErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;

public class Assert {

    private Assert() {
        // Nothing
    }

    public static void assertNotNull(Object object, ErrorEnum error) {
        if (object == null) throw new ApplicationException(error);
    }

    public static void assertNull(Object object, ErrorEnum error) {
        if (object != null) throw new ApplicationException(error);
    }

    public static void assertNotEmpty(String string, ErrorEnum error) {
        if (string == null || string.isBlank()) throw new ApplicationException(error);
    }

    public static void assertEmpty(String string, ErrorEnum error) {
        if (string != null && !string.isBlank()) throw new ApplicationException(error);
    }

}
