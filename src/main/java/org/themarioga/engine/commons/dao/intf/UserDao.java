package org.themarioga.engine.commons.dao.intf;

import org.themarioga.engine.commons.dao.InterfaceHibernateDao;
import org.themarioga.engine.commons.models.User;

public interface UserDao extends InterfaceHibernateDao<User> {

    User getByUsername(String username);

}
