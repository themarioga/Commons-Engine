package org.themarioga.commons.engine.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.commons.engine.config.CommonsConfig;
import org.themarioga.commons.engine.dao.intf.LanguageDao;
import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.services.intf.LanguageService;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

    private final LanguageDao languageDao;
    private final CommonsConfig commonsConfig;

    @Autowired
    public LanguageServiceImpl(LanguageDao languageDao, CommonsConfig commonsConfig) {
        this.languageDao = languageDao;
        this.commonsConfig = commonsConfig;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Lang getLanguage(String id) {
        logger.debug("Getting language by id: {}", id);

        return languageDao.getLanguage(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Lang getDefaultLanguage() {
        logger.debug("Getting default language");

        return languageDao.getLanguage(commonsConfig.getDefaultLanguage());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Lang> getLangs() {
        logger.debug("Getting all languages");

        return languageDao.getLanguages();
    }

}
