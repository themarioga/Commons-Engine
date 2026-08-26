package org.themarioga.commons.engine.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themarioga.commons.engine.dao.intf.TagDao;
import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.models.Tag;
import org.themarioga.commons.engine.services.intf.LanguageService;
import org.themarioga.commons.engine.services.intf.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;
    private final LanguageService languageService;

    @Autowired
    public TagServiceImpl(TagDao tagDao, LanguageService languageService) {
        this.tagDao = tagDao;
        this.languageService = languageService;
    }

    @Override
    public List<Tag> getTagsByLang(String lang) {
        Lang language = languageService.getLanguage(lang);
        if (language == null) language = languageService.getDefaultLanguage();

        return tagDao.getTagsByLang(language);
    }

}
