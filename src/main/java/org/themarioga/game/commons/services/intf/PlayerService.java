package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

import java.util.UUID;

public interface PlayerService<T extends Player> {

    T create(Game game, User user);

    void delete(T player);

    T findById(UUID id);

    T findByUser(User user);

    T findByUserId(UUID userId);

}
