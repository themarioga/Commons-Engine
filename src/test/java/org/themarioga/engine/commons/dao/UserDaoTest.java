package org.themarioga.engine.commons.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.themarioga.engine.commons.dao.impl.UserDaoImpl;
import org.themarioga.engine.commons.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

    @InjectMocks
    private UserDaoImpl userDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        user.setName("First");
        user.setActive(true);
    }

    @Test
    void createUser() {
        when(entityManager.merge(any(User.class))).thenReturn(user);

        User newUser = new User();
        newUser.setName("Test user");

        User createdUser = userDao.createOrUpdate(newUser);

        Assertions.assertNotNull(createdUser.getId());
        Assertions.assertEquals("First", createdUser.getName());
        verify(entityManager).merge(newUser);
    }

    @Test
    void updateUser() {
        when(entityManager.merge(any(User.class))).thenReturn(user);

        user.setName("Otro nombre");
        user.setActive(false);

        User updatedUser = userDao.createOrUpdate(user);

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), updatedUser.getId());
        Assertions.assertEquals("Otro nombre", updatedUser.getName());
        verify(entityManager).merge(user);
    }

    @Test
    void deleteUser() {
        doNothing().when(entityManager).remove(user);

        userDao.delete(user);

        verify(entityManager).remove(user);
    }

    @Test
    void findUser() {
        when(entityManager.find(User.class, user.getId())).thenReturn(user);

        User foundUser = userDao.findOne(user.getId());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), foundUser.getId());
        Assertions.assertEquals("First", foundUser.getName());
        Assertions.assertEquals(true, foundUser.getActive());
    }

    @Test
    @SuppressWarnings("unchecked")
    void findAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(user);

        TypedQuery<User> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(User.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(list);

        List<User> users = userDao.findAll();

        Assertions.assertEquals(1, users.size());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), users.get(0).getId());
        Assertions.assertEquals("First", users.get(0).getName());
        Assertions.assertEquals(true, users.get(0).getActive());
    }

    @Test
    @SuppressWarnings("unchecked")
    void countAllUsers() {
        TypedQuery<User> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(User.class))).thenReturn(typedQuery);
        when(typedQuery.getResultStream()).thenReturn(Stream.of(user));

        long total = userDao.countAll();

        Assertions.assertEquals(1, total);
    }

    @Test
    @SuppressWarnings("unchecked")
    void getByUsername() {
        Query<User> query = mock(Query.class);
        when(entityManager.unwrap(Session.class)).thenReturn(session);
        when(session.createQuery(anyString(), eq(User.class))).thenReturn(query);
        when(query.setParameter(anyString(), anyString())).thenReturn(query);
        when(query.getSingleResultOrNull()).thenReturn(user);

        User foundUser = userDao.getByUsername("First");
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals("First", foundUser.getName());
    }

}
