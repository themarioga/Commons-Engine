package org.themarioga.engine.commons.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.themarioga.engine.commons.dao.intf.UserDao;
import org.themarioga.engine.commons.enums.CommonErrorEnum;
import org.themarioga.engine.commons.exceptions.ApplicationException;
import org.themarioga.engine.commons.exceptions.user.UserAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.user.UserDoesntExistsException;
import org.themarioga.engine.commons.exceptions.user.UserNotActiveException;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.User;
import org.themarioga.engine.commons.services.intf.UserService;
import org.themarioga.engine.commons.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public User createOrReactivate(String username, String name, Lang language) {
        logger.debug("Creating or reactivating user: {} / {} ({})", username, name, language);

        Assert.assertNotEmpty(username, CommonErrorEnum.USER_USERNAME_EMPTY);
        Assert.assertNotEmpty(name, CommonErrorEnum.USER_NAME_EMPTY);

        User userFromBd = userDao.getByUsername(username);
        if (userFromBd == null) {
            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setActive(true);
            user.setLang(language);
            user.setCreationDate(new Date());
            return userDao.createOrUpdate(user);
        } else {
            if (Boolean.FALSE.equals(userFromBd.getActive())) {
                userFromBd.setName(name);
                userFromBd.setActive(true);
                return userDao.createOrUpdate(userFromBd);
            } else {
                logger.error("Error trying to create user {} ({}): Already exists", username, language);
                throw new UserAlreadyExistsException();
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public User rename(User user, String newName) {
        logger.debug("Renaming user with ID {} to {}", user.getId(), newName);

        Assert.assertNotEmpty(newName, CommonErrorEnum.USER_NAME_EMPTY);

        user.setName(newName);

        return userDao.createOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public User setUsername(User user, String newUsername) {
        logger.debug("Changing username of user with ID {} to {}", user.getId(), newUsername);

        Assert.assertNotEmpty(newUsername, CommonErrorEnum.USER_USERNAME_EMPTY);

        user.setUsername(newUsername);

        return userDao.createOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public User setActive(User user, boolean active) {
        logger.debug("Activating/Deactivating user with ID {} to {}", user.getId(), active);

        user.setActive(active);

        return userDao.createOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ApplicationException.class)
    public User setLanguage(User user, Lang language) {
        logger.debug("Changing lang to user with ID {} to {}", user.getId(), language);

        user.setLang(language);

        return userDao.createOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getById(UUID id) {
        logger.debug("Getting user with ID: {}", id);

        User user = userDao.findOne(id);
        if (user == null) {
            logger.error("Error getting user with id {}: Doesn't exists.", id);
            throw new UserDoesntExistsException();
        }
        if (Boolean.FALSE.equals(user.getActive())) {
            logger.error("Error getting user with id {}: Not active.", id);
            throw new UserNotActiveException();
        }

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getByUsername(String username) {
        logger.debug("Getting user with username: {}", username);

        User user = userDao.getByUsername(username);
        if (user == null) {
            logger.error("Error getting user with username {}: Doesn't exists.", username);
            throw new UserDoesntExistsException();
        }

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getAllUsers() {
        logger.debug("Getting all users");

        return userDao.findAll();
    }

}
