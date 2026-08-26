package org.themarioga.commons.engine.dao.intf;

import org.themarioga.commons.engine.dao.InterfaceHibernateDao;
import org.themarioga.commons.engine.models.User;

public interface UserDao extends InterfaceHibernateDao<User> {

    User getByUsername(String username);

}
