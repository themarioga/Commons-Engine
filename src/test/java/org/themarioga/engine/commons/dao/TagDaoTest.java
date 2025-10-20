package org.themarioga.engine.commons.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.BaseTest;
import org.themarioga.engine.commons.dao.intf.LanguageDao;
import org.themarioga.engine.commons.dao.intf.TagDao;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.Tag;

import java.util.List;

@DatabaseSetup("classpath:dbunit/dao/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/dao/setup/tag.xml")
class TagDaoTest extends BaseTest {

    @Autowired
    private LanguageDao languageDao;

    @Autowired
    private TagDao tagDao;

    @Test
    void testFindTag() {
        Lang lang = languageDao.getLanguage("es");

        List<Tag> tagList = tagDao.getTagsByLang(lang);

        Assertions.assertEquals(1, tagList.size());
    }

}
