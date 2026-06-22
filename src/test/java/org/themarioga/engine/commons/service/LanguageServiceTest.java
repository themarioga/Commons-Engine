package org.themarioga.engine.commons.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.config.CommonsConfig;
import org.themarioga.engine.commons.dao.intf.LanguageDao;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.services.impl.LanguageServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LanguageServiceTest {

    @InjectMocks
    private LanguageServiceImpl languageService;

    @Mock
    private LanguageDao languageDao;

    @Mock
    private CommonsConfig commonsConfig;

    private Lang defaultLang;

    @BeforeEach
    void setUp() {
        defaultLang = new Lang();
        defaultLang.setId("es");
        defaultLang.setName("Español");
    }

    @Test
    void testGetLanguage() {
        when(languageDao.getLanguage("es")).thenReturn(defaultLang);
        Lang language = languageService.getLanguage("es");

        Assertions.assertNotNull(language);
        Assertions.assertEquals("es", language.getId());
        Assertions.assertEquals("Español", language.getName());
    }

    @Test
    void testGetDefaultLanguage() {
        when(commonsConfig.getDefaultLanguage()).thenReturn("es");
        when(languageDao.getLanguage("es")).thenReturn(defaultLang);

        Lang language = languageService.getDefaultLanguage();

        Assertions.assertNotNull(language);
        Assertions.assertEquals("es", language.getId());
        Assertions.assertEquals("Español", language.getName());
    }

    @Test
    void testGetAllLanguages() {
        List<Lang> mockList = new ArrayList<>();
        mockList.add(defaultLang);
        mockList.add(new Lang());
        when(languageDao.getLanguages()).thenReturn(mockList);

        List<Lang> langList = languageService.getLangs();

        Assertions.assertEquals(2, langList.size());
        Assertions.assertEquals("es", langList.get(0).getId());
    }

}
