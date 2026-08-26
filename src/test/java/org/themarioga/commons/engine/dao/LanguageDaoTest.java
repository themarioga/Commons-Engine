package org.themarioga.commons.engine.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.commons.engine.dao.impl.LanguageDaoImpl;
import org.themarioga.commons.engine.models.Lang;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LanguageDaoTest {

    private LanguageDaoImpl languageDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    private Lang lang;

    @BeforeEach
    void setUp() {
        languageDao = new LanguageDaoImpl(entityManager);
        lang = new Lang();
        lang.setId("es");
        lang.setName("Español");
    }

    @Test
    @SuppressWarnings("unchecked")
    void testFindById() {
        Query<Lang> query = mock(Query.class);
        when(entityManager.unwrap(any())).thenReturn(session);
        when(session.createQuery(anyString(), eq(Lang.class))).thenReturn(query);
        when(query.setParameter("id", "es")).thenReturn(query);
        when(query.getSingleResultOrNull()).thenReturn(lang);

        Lang foundLang = languageDao.getLanguage("es");

        Assertions.assertNotNull(foundLang);
        Assertions.assertEquals("es", foundLang.getId());
        Assertions.assertEquals("Español", foundLang.getName());
    }

    @Test
    @SuppressWarnings("unchecked")
    void testCheckLangExists() {
        Query<Long> query = mock(Query.class);
        when(entityManager.unwrap(any())).thenReturn(session);
        when(session.createQuery(anyString(), eq(Long.class))).thenReturn(query);
        when(query.setParameter("id", "es")).thenReturn(query);
        when(query.getSingleResultOrNull()).thenReturn(1L);

        Assertions.assertTrue(languageDao.checkLanguageExists("es"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void testFindAll() {
        List<Lang> list = new ArrayList<>();
        list.add(lang);
        list.add(new Lang());

        Query<Lang> query = mock(Query.class);
        when(entityManager.unwrap(any())).thenReturn(session);
        when(session.createQuery(anyString(), eq(Lang.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(list);

        List<Lang> langList = languageDao.getLanguages();

        Assertions.assertEquals(2, langList.size());
        Assertions.assertEquals("es", langList.get(0).getId());
    }

}
