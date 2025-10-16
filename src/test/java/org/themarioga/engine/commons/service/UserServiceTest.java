package org.themarioga.engine.commons.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.themarioga.engine.commons.Base;
import org.themarioga.engine.commons.exceptions.user.UserAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.user.UserDoesntExistsException;
import org.themarioga.engine.commons.exceptions.user.UserNotActiveException;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.User;
import org.themarioga.engine.commons.services.intf.LanguageService;
import org.themarioga.engine.commons.services.intf.UserService;

import java.util.List;
import java.util.UUID;

@DatabaseSetup("classpath:dbunit/service/setup/lang.xml")
@DatabaseSetup("classpath:dbunit/service/setup/user.xml")
class UserServiceTest extends Base {

    @Autowired
    UserService userService;

    @Autowired
    LanguageService languageService;

    @Test
    void testCreateOrReactivate() {
        User user = userService.createOrReactivate("Test", languageService.getDefaultLanguage());

        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("Test", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testCreateOrReactivate_Reactivate() {
        User user = userService.createOrReactivate("Third", languageService.getDefaultLanguage());

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), user.getId());
        Assertions.assertEquals("Third", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testCreateOrReactivate_AlreadyActive() {
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
            userService.createOrReactivate("First", languageService.getDefaultLanguage());

            Assertions.fail();
        });
    }

    @Test
    void testCreateOrReactivate_AlreadyExists() {
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
            userService.createOrReactivate("Second", languageService.getDefaultLanguage());

            Assertions.fail();
        });
    }

    @Test
    void testRename() {
        User user = userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        userService.rename(user, "Newname");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("Newname", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testSetActive() {
        User user = userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        userService.setActive(user, false);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(false, user.getActive());
    }

    @Test
    void testSetLanguage() {
        User user = userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        Lang lang = languageService.getDefaultLanguage();

        userService.setLanguage(user, lang);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("es", user.getLang().getId());
    }

    @Test
    void testGetById() {
        User user = userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000000"));

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testGetById_NonExistant() {
        Assertions.assertThrows(UserDoesntExistsException.class, () -> userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000001")));
    }

    @Test
    void testGetById_NotActive() {
        Assertions.assertThrows(UserNotActiveException.class, () -> userService.getById(UUID.fromString("22222222-2222-2222-2222-222222222222")));
    }

    @Test
    void testGetByUsername() {
        User user = userService.getByUsername("First");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testGetByUsername_NonExistant() {
        Assertions.assertThrows(UserDoesntExistsException.class, () -> userService.getByUsername("John Doe"));
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = userService.getAllUsers();

        Assertions.assertEquals(7, userList.size());
    }

}
