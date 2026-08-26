package org.themarioga.commons.engine.services.intf;

import org.themarioga.commons.engine.models.Lang;
import org.themarioga.commons.engine.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createOrReactivate(String username, String name, Lang language);

    User rename(User user, String newName);

    User setUsername(User user, String newUsername);

    User setActive(User user, boolean active);

    User setLanguage(User user, Lang language);

    User getById(UUID id);

    User getByUsername(String username);

    List<User> getAllUsers();

}
