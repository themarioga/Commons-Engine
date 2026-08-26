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
import org.themarioga.commons.engine.dao.impl.TagDaoImpl;
import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.models.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagDaoTest {

    private TagDaoImpl tagDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    @BeforeEach
    void setUp() {
        // TagDaoImpl inyecta el EntityManager por constructor sobre un campo final, así que se
        // construye a mano: @InjectMocks no le hace llegar el mock stubbeado.
        tagDao = new TagDaoImpl(entityManager);
    }

    @Test
    @SuppressWarnings("unchecked")
    void testFindTag() {
        Lang lang = new Lang();
        lang.setId("es");
        lang.setName("Español");

        List<Tag> list = new ArrayList<>();
        list.add(new Tag());

        Query<Tag> query = mock(Query.class);
        when(entityManager.unwrap(Session.class)).thenReturn(session);
        when(session.createQuery(anyString(), eq(Tag.class))).thenReturn(query);
        when(query.setParameter("lang", lang)).thenReturn(query);
        when(query.getResultList()).thenReturn(list);

        List<Tag> tagList = tagDao.getTagsByLang(lang);

        Assertions.assertEquals(1, tagList.size());
    }

}
