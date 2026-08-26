package org.themarioga.commons.engine.dao.impl;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.themarioga.commons.engine.dao.intf.TagDao;
import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.models.Tag;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {

    private final EntityManager entityManager;

    @Autowired
    public TagDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Tag> getTagsByLang(Lang lang) {
        return getCurrentSession().createQuery("SELECT t FROM Tag t WHERE t.lang=:lang", Tag.class).setParameter("lang", lang).getResultList();
    }

    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }
}
