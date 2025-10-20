package org.themarioga.engine.commons.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.BaseTest;
import org.themarioga.engine.commons.dao.intf.LanguageDao;
import org.themarioga.engine.commons.dao.intf.UserDao;
import org.themarioga.engine.commons.models.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@DatabaseSetup("classpath:dbunit/dao/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/dao/setup/user.xml")
class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LanguageDao languageDao;

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/dao/expected/user/testCreateUser-expected.xml", table = "Users", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void createUser() {
        User user = new User();
        user.setName("Test user");
        user.setActive(true);
        user.setLang(languageDao.getLanguage("es"));
        user.setCreationDate(new Date());

        user = userDao.createOrUpdate(user);
        getCurrentSession().flush();

        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("Test user", user.getName());
    }

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/dao/expected/user/testUpdateUser-expected.xml", table = "Users", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void updateUser() {
        User user = userDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        user.setName("Otro nombre");
        user.setActive(false);

        userDao.createOrUpdate(user);
        getCurrentSession().flush();

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("Otro nombre", user.getName());
    }

    @Test
    void deleteUser() {
        User user = userDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        userDao.delete(user);
        getCurrentSession().flush();

        long total = userDao.countAll();

        Assertions.assertEquals(0, total);
    }

    @Test
    void findUser() {
        User user = userDao.findOne(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void findAllUsers() {
        List<User> users = userDao.findAll();

        Assertions.assertEquals(1, users.size());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), users.get(0).getId());
        Assertions.assertEquals("First", users.get(0).getName());
        Assertions.assertEquals(true, users.get(0).getActive());
    }

    @Test
    void countAllUsers() {
        long total = userDao.countAll();

        Assertions.assertEquals(1, total);
    }

}
