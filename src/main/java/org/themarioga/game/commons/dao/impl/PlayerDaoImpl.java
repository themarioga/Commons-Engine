package org.themarioga.game.commons.dao.impl;

import org.springframework.stereotype.Repository;
import org.themarioga.game.commons.dao.AbstractHibernateDao;
import org.themarioga.game.commons.dao.intf.PlayerDao;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

@Repository
public class PlayerDaoImpl extends AbstractHibernateDao<Player> implements PlayerDao {

    public PlayerDaoImpl() {
        setClazz(Player.class);
    }

    @Override
    public Player findPlayerByUser(User user) {
        return getCurrentSession().createQuery("SELECT t FROM Player t where user=:user", Player.class).setParameter("user", user).getSingleResultOrNull();
    }

}
