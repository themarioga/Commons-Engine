package org.themarioga.commons.engine.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.commons.engine.dao.intf.TagDao;
import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.services.impl.TagServiceImpl;
import org.themarioga.commons.engine.services.intf.LanguageService;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private TagDao tagDao;

    @Mock
    private LanguageService languageService;

    @Test
    void testGetTagsByLang() {
        Lang lang = new Lang();
        lang.setId("en");
        lang.setName("English");

        when(languageService.getLanguage("en")).thenReturn(lang);
        when(tagDao.getTagsByLang(lang)).thenReturn(new ArrayList<>());

        Assertions.assertNotNull(tagService.getTagsByLang("en"));
    }

}
