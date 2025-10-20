package org.themarioga.engine.commons.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.BaseTest;
import org.themarioga.engine.commons.dao.intf.ConfigurationDao;

class ConfigurationDaoTest extends BaseTest {

    @Autowired
    private ConfigurationDao configurationDao;

    @Test
    void testGetConfiguration() {
        String value = configurationDao.getConfiguration("default_language");

        Assertions.assertEquals("es", value);
    }

}
