package org.themarioga.game.commons.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.game.commons.Base;
import org.themarioga.game.commons.dao.intf.ConfigurationDao;

class ConfigurationDaoTest extends Base {

    @Autowired
    private ConfigurationDao configurationDao;

    @Test
    void testGetConfiguration() {
        String value = configurationDao.getConfiguration("default_language");

        Assertions.assertEquals("es", value);
    }

}
