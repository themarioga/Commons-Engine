package org.themarioga.engine.commons.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.engine.commons.dao.intf.TagDao;
import org.themarioga.engine.commons.exceptions.ApplicationException;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.Tag;
import org.themarioga.engine.commons.security.SecurityUtils;
import org.themarioga.engine.commons.services.intf.LanguageService;
import org.themarioga.engine.commons.services.intf.I18NService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class I18NServiceImpl implements I18NService {

    private final Map<String, Map<String, String>> langTagMap = new HashMap<>();

    private final LanguageService languageService;

    @Autowired
    public I18NServiceImpl(TagDao tagDao, LanguageService languageService) {
        this.languageService = languageService;

        getLangTags(tagDao, languageService);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public Lang getLanguage(String lang) {
        Lang language;
        if (lang != null) {
            language = languageService.getLanguage(lang);

            if (language == null)
                language = languageService.getDefaultLanguage();
        } else {
            language = languageService.getDefaultLanguage();
        }

        return language;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public List<Lang> getLanguages() {
        return languageService.getLangs();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public String get(String tag, String lang) {
        return getTextByTag(tag, getLanguage(lang));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public String get(String tag) {
        return getTextByTag(tag, getUserLangOrDefault());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public String get(String tag, Lang lang) {
        return getTextByTag(tag, lang);
    }

    private String getTextByTag(String tag, Lang lang) {
        String text = langTagMap.get(lang.getId()).get(tag);
        return text != null ? text : tag;
    }

    private void getLangTags(TagDao tagDao, LanguageService languageService) {
        List<Lang> langs = languageService.getLangs();
        for (Lang lang : langs) {
            Map<String, String> tagMap = new HashMap<>();

            List<Tag> tags = tagDao.getTagsByLang(lang);
            for (Tag tag : tags) {
                tagMap.put(tag.getTag(), tag.getText().replace("\\n", "\n"));
            }

            langTagMap.put(lang.getId(), tagMap);
        }
    }

    private Lang getUserLangOrDefault() {
        Lang lang = SecurityUtils.getLang();
        return lang != null ? lang : languageService.getDefaultLanguage();
    }
}
