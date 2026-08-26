package org.themarioga.engine.commons.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.dao.intf.UserDao;
import org.themarioga.engine.commons.exceptions.user.UserAlreadyExistsException;
import org.themarioga.engine.commons.exceptions.user.UserDoesntExistsException;
import org.themarioga.engine.commons.exceptions.user.UserNotActiveException;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.User;
import org.themarioga.engine.commons.services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserDao userDao;

    // test variables
    private User activeUser;
    private User inactiveUser;
    private Lang defaultLang;

    @BeforeEach
    void setUp() {
        defaultLang = new Lang();
        defaultLang.setId("es");
        defaultLang.setName("Español");

        activeUser = new User();
        activeUser.setId(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        activeUser.setUsername("first");
        activeUser.setName("First");
        activeUser.setActive(true);
        activeUser.setLang(defaultLang);

        inactiveUser = new User();
        inactiveUser.setId(UUID.fromString("22222222-2222-2222-2222-222222222222"));
        inactiveUser.setUsername("third");
        inactiveUser.setName("Third");
        inactiveUser.setActive(false);
        inactiveUser.setLang(defaultLang);
    }

    @Test
    void testCreateOrReactivate() {
        when(userDao.getByUsername("test")).thenReturn(null);
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(UUID.randomUUID());
            return u;
        });

        User user = userService.createOrReactivate("test", "Test", defaultLang);

        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("test", user.getUsername());
        Assertions.assertEquals("Test", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    /**
     * Un usuario sin alias de Telegram se identifica por "tg:&lt;id&gt;", que no puede colisionar con
     * un alias real porque Telegram no admite ':' en los alias.
     */
    @Test
    void testCreateOrReactivate_SyntheticUsername() {
        when(userDao.getByUsername("tg:123456789")).thenReturn(null);
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(UUID.randomUUID());
            return u;
        });

        User user = userService.createOrReactivate("tg:123456789", "Mario García", defaultLang);

        Assertions.assertEquals("tg:123456789", user.getUsername());
        Assertions.assertEquals("Mario García", user.getName());
    }

    @Test
    void testCreateOrReactivate_Reactivate() {
        when(userDao.getByUsername("third")).thenReturn(inactiveUser);
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User user = userService.createOrReactivate("third", "Third renombrado", defaultLang);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("22222222-2222-2222-2222-222222222222"), user.getId());
        Assertions.assertEquals("third", user.getUsername());
        Assertions.assertEquals("Third renombrado", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testCreateOrReactivate_AlreadyActive() {
        when(userDao.getByUsername("first")).thenReturn(activeUser);

        Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
            userService.createOrReactivate("first", "First", defaultLang);
        });
    }

    /**
     * Dos personas distintas pueden llamarse igual: el nombre visible ya no es identidad, así que
     * crear un usuario con un nombre repetido pero distinto username debe funcionar.
     */
    @Test
    void testCreateOrReactivate_DuplicatedNameIsAllowed() {
        when(userDao.getByUsername("second")).thenReturn(null);
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(UUID.randomUUID());
            return u;
        });

        User user = userService.createOrReactivate("second", "First", defaultLang);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("second", user.getUsername());
        Assertions.assertEquals("First", user.getName());
    }

    @Test
    void testRename() {
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User user = userService.rename(activeUser, "Newname");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("Newname", user.getName());
        Assertions.assertEquals("first", user.getUsername(), "renombrar no debe tocar la identidad");
        Assertions.assertEquals(true, user.getActive());
    }

    /**
     * Cuando un usuario de Telegram libera su alias y otro lo coge, la capa de Telegram degrada al
     * antiguo dueño y le asigna el alias al nuevo: aquí se comprueba la primitiva que lo permite.
     */
    @Test
    void testSetUsername() {
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User user = userService.setUsername(activeUser, "tg:987654321");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("tg:987654321", user.getUsername());
        Assertions.assertEquals("First", user.getName(), "cambiar la identidad no debe tocar el nombre visible");
    }

    @Test
    void testSetActive() {
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User user = userService.setActive(activeUser, false);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(false, user.getActive());
    }

    @Test
    void testSetLanguage() {
        when(userDao.createOrUpdate(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User user = userService.setLanguage(activeUser, defaultLang);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("es", user.getLang().getId());
    }

    @Test
    void testGetById() {
        when(userDao.findOne(activeUser.getId())).thenReturn(activeUser);

        User user = userService.getById(activeUser.getId());

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testGetById_NonExistant() {
        when(userDao.findOne(any())).thenReturn(null);
        Assertions.assertThrows(UserDoesntExistsException.class, () -> userService.getById(UUID.fromString("00000000-0000-0000-0000-000000000001")));
    }

    @Test
    void testGetById_NotActive() {
        when(userDao.findOne(inactiveUser.getId())).thenReturn(inactiveUser);
        Assertions.assertThrows(UserNotActiveException.class, () -> userService.getById(inactiveUser.getId()));
    }

    @Test
    void testGetByUsername() {
        when(userDao.getByUsername("first")).thenReturn(activeUser);
        User user = userService.getByUsername("first");

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), user.getId());
        Assertions.assertEquals("First", user.getName());
        Assertions.assertEquals(true, user.getActive());
    }

    @Test
    void testGetByUsername_NonExistant() {
        when(userDao.getByUsername("John Doe")).thenReturn(null);
        Assertions.assertThrows(UserDoesntExistsException.class, () -> userService.getByUsername("John Doe"));
    }

    @Test
    void testGetAllUsers() {
        List<User> mockList = new ArrayList<>();
        for (int i = 0; i < 7; i++) mockList.add(new User());
        when(userDao.findAll()).thenReturn(mockList);

        List<User> userList = userService.getAllUsers();

        Assertions.assertEquals(7, userList.size());
    }

}
