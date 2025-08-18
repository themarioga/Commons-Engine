package org.themarioga.game.commons.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.game.commons.Base;
import org.themarioga.game.commons.dao.intf.LanguageDao;
import org.themarioga.game.commons.dao.intf.TagDao;
import org.themarioga.game.commons.models.Lang;
import org.themarioga.game.commons.models.Tag;

import java.util.List;

@DatabaseSetup("classpath:dbunit/dao/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/dao/setup/tag.xml")
class TagDaoTest extends Base {

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
