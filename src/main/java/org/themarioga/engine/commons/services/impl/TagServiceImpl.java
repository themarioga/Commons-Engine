package org.themarioga.engine.commons.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themarioga.engine.commons.dao.intf.TagDao;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.Tag;
import org.themarioga.engine.commons.services.intf.LanguageService;
import org.themarioga.engine.commons.services.intf.TagService;

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
