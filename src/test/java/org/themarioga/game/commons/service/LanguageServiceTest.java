package org.themarioga.game.commons.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.game.commons.Base;
import org.themarioga.game.commons.models.Lang;
import org.themarioga.game.commons.services.intf.LanguageService;

import java.util.List;

@DatabaseSetup("classpath:dbunit/service/setup/lang.xml")
class LanguageServiceTest extends Base {

    @Autowired
    private LanguageService languageService;

    @Test
    void testGetLanguage() {
        Lang language = languageService.getLanguage("es");

        Assertions.assertNotNull(language);
        Assertions.assertEquals("es", language.getId());
        Assertions.assertEquals("Español", language.getName());
    }

    @Test
    void testGetDefaultLanguage() {
        Lang language = languageService.getDefaultLanguage();

        Assertions.assertNotNull(language);
        Assertions.assertEquals("es", language.getId());
        Assertions.assertEquals("Español", language.getName());
    }

    @Test
    void testGetAllLanguages() {
        List<Lang> langList = languageService.getLangs();

        Assertions.assertEquals(2, langList.size());
        Assertions.assertEquals("es", langList.get(0).getId());
    }

}
