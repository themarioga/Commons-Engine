package org.themarioga.game.commons.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.game.commons.Base;
import org.themarioga.game.commons.dao.intf.LanguageDao;
import org.themarioga.game.commons.models.Lang;

import java.util.List;

@DatabaseSetup("classpath:dbunit/dao/setup/lang.xml")
class LanguageDaoTest extends Base {

	@Autowired
	private LanguageDao languageDao;

	@Test
	void testFindById() {
		Lang lang = languageDao.getLanguage("es");

		Assertions.assertNotNull(lang);
		Assertions.assertEquals("es", lang.getId());
		Assertions.assertEquals("Español", lang.getName());
	}

	@Test
	void testCheckLangExists() {
		Assertions.assertTrue(languageDao.checkLanguageExists("es"));
	}

	@Test
	void testFindAll() {
		List<Lang> langList = languageDao.getLanguages();

		Assertions.assertEquals(2, langList.size());
		Assertions.assertEquals("es", langList.get(0).getId());
	}

}
