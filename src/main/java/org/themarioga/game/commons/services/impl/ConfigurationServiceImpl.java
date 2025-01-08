package org.themarioga.game.commons.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.game.commons.dao.intf.ConfigurationDao;
import org.themarioga.game.commons.exceptions.ApplicationException;
import org.themarioga.game.commons.services.intf.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);

    private final ConfigurationDao configurationDao;

    @Autowired
    public ConfigurationServiceImpl(ConfigurationDao configurationDao) {
        this.configurationDao = configurationDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public String getConfiguration(String key) {
        logger.debug("Getting configuration by key: {}", key);

        return configurationDao.getConfiguration(key);
    }

}
