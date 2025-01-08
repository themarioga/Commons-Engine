package org.themarioga.game.commons.dao.intf;

import org.themarioga.game.commons.dao.InterfaceHibernateDao;
import org.themarioga.game.commons.models.User;

public interface UserDao extends InterfaceHibernateDao<User> {

    User getByUsername(String username);

}
