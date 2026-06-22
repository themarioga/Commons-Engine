package org.themarioga.engine.commons.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.dao.intf.TagDao;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.services.impl.TagServiceImpl;
import org.themarioga.engine.commons.services.intf.LanguageService;

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
