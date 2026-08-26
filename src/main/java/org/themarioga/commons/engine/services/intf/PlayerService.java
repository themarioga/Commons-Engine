package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Game;
import org.themarioga.commons.engine.models.Player;
import org.themarioga.commons.engine.models.User;

import java.util.UUID;

public interface PlayerService<P extends Player, G extends Game> {

    P create(G game, User user);

    void delete(P player);

    P findById(UUID id);

    P findByUser(User user);

    P findByUserId(UUID userId);

    P findPlayerByGameAndUser(G game, User user);

}
