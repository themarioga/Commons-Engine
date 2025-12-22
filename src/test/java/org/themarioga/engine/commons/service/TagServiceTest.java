package org.themarioga.engine.commons.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.BaseTest;
import org.themarioga.engine.commons.services.intf.TagService;

@DatabaseSetup("classpath:dbunit/service/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/service/setup/tag.xml")
class TagServiceTest extends BaseTest {

    @Autowired
    private TagService tagService;

    @Test
    void testGetTagsByLang() {
        Assertions.assertNotNull(tagService.getTagsByLang("en"));
    }

}
