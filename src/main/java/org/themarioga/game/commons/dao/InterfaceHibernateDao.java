package org.themarioga.game.commons.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface InterfaceHibernateDao<T extends Serializable> {
    // API
    T createOrUpdate(T entity);

    void delete(T entity);

    void deleteById(UUID id);

    T findOne(UUID id);

    List<T> findAll();

    Long countAll();

    EntityManager getEntityManager();

    Session getCurrentSession();
}
