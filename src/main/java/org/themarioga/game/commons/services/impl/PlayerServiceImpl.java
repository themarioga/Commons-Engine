package org.themarioga.game.commons.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.game.commons.dao.intf.PlayerDao;
import org.themarioga.game.commons.enums.ErrorEnum;
import org.themarioga.game.commons.enums.GameStatusEnum;
import org.themarioga.game.commons.exceptions.ApplicationException;
import org.themarioga.game.commons.exceptions.game.GameAlreadyStartedException;
import org.themarioga.game.commons.exceptions.player.PlayerAlreadyExistsException;
import org.themarioga.game.commons.models.Game;
import org.themarioga.game.commons.models.Player;
import org.themarioga.game.commons.models.User;
import org.themarioga.game.commons.services.intf.PlayerService;
import org.themarioga.game.commons.services.intf.UserService;
import org.themarioga.game.commons.util.Assert;

import java.util.Date;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private final PlayerDao playerDao;
    private final UserService userService;

    @Autowired
    public PlayerServiceImpl(PlayerDao playerDao, UserService userService) {
        this.playerDao = playerDao;
        this.userService = userService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public Player create(Game game, long userId) {
        logger.debug("Creating player from user {} in game {}", userId, game);

        // Check game is not null
        Assert.assertNotNull(game, ErrorEnum.GAME_NOT_FOUND);

        // Check if the game is already started
        if (game.getStatus() == GameStatusEnum.STARTED)
            throw new GameAlreadyStartedException();

        // Check user is not null
        Assert.assertNotNull(userId, ErrorEnum.USER_NOT_FOUND);

        // Get the user
        User user = userService.getById(userId);

        // Check user exists
        Assert.assertNotNull(user, ErrorEnum.USER_NOT_FOUND);

        // Check if the user is already playing
        if (playerDao.findPlayerByUser(user) != null)
            throw new PlayerAlreadyExistsException();

        // Create player
        Player player = new Player();
        player.setGame(game);
        player.setUser(user);
        player.setJoinOrder(game.getPlayers().size());
        player.setCreationDate(new Date());
        return playerDao.create(player);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public void delete(Player player) {
        logger.debug("Delete player {}", player);

        playerDao.delete(player);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public Player findById(long id) {
        logger.debug("Getting player with ID: {}", id);

        return playerDao.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public Player findByUser(User user) {
        logger.debug("Getting player with user: {}", user);

        return playerDao.findPlayerByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = ApplicationException.class)
    public Player findByUserId(long id) {
        logger.debug("Getting player with user ID: {}", id);

        return playerDao.findPlayerByUser(userService.getById(id));
    }

}
