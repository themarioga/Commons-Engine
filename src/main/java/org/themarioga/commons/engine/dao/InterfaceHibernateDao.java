package org.themarioga.commons.engine.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface InterfaceHibernateDao<T extends Serializable> {
    // API
    /**
     * Da de alta una entidad nueva.
     * <p>
     * No vale {@link #createOrUpdate} para esto cuando el identificador es asignado o derivado de
     * otra entidad: {@code merge} necesita leer el id para buscar la fila que actualizar, y en una
     * entidad recién creada todavía no lo hay.
     */
    T create(T entity);

    T createOrUpdate(T entity);

    void delete(T entity);

    void deleteById(UUID id);

    T findOne(UUID id);

    List<T> findAll();

    Long countAll();

    EntityManager getEntityManager();

    Session getCurrentSession();
}
