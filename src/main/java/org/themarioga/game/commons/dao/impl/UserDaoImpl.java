package org.themarioga.game.commons.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.game.commons.dao.AbstractHibernateDao;
import org.themarioga.game.commons.dao.intf.UserDao;
import org.themarioga.game.commons.models.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User getByUsername(String username) {
        return getCurrentSession().createQuery("SELECT u FROM User u WHERE u.name LIKE :username", User.class).setParameter("username", "%" + username + "%").getSingleResultOrNull();
    }

}
