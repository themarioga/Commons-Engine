package org.themarioga.commons.engine.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractHibernateDao<T extends Serializable> implements InterfaceHibernateDao<T> {

    private Class<T> clazz;

    protected EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        clazz = Objects.requireNonNull(clazzToSet);
    }

    // API
    @Override
    public T create(final T entity) {
        Assert.notNull(entity, "No puede ser null");

        getEntityManager().persist(entity);

        return entity;
    }

    @Override
    public T createOrUpdate(final T entity) {
        Assert.notNull(entity, "No puede ser null");

        return getEntityManager().merge(entity);
    }

    @Override
    public void delete(final T entity) {
        Assert.notNull(entity, "No puede ser null");
        getEntityManager().remove(entity);
    }

    @Override
    public void deleteById(final UUID entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    @Override
    public T findOne(final UUID id) {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    @Override
    public Long countAll() {
        return getEntityManager().createQuery("from " + clazz.getName(), clazz).getResultStream().count();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    @Autowired
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}