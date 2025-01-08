package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

public interface PlayerService {

    Player create(Game game, long userId);

    void delete(Player player);

    Player findById(long id);

    Player findByUser(User user);

    Player findByUserId(long id);

}
