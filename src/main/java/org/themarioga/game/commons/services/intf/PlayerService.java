package org.themarioga.game.commons.services.intf;

import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;

import java.util.UUID;

public interface PlayerService<P extends Player, G extends Game> {

    P create(G game, User user);

    void delete(P player);

    P findById(UUID id);

    P findByUser(User user);

    P findByUserId(UUID userId);

}
