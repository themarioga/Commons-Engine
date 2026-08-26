package org.themarioga.commons.engine.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.commons.engine.dao.AbstractHibernateDao;
import org.themarioga.commons.engine.dao.intf.UserDao;
import org.themarioga.commons.engine.models.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User getByUsername(String username) {
        return getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username = :username", User.class).setParameter("username", username).getSingleResultOrNull();
    }

}
