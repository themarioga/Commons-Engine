package org.themarioga.engine.commons.services.intf;

import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createOrReactivate(String name, Lang language);

    User rename(User user, String newName);

    User setActive(User user, boolean active);

    User setLanguage(User user, Lang language);

    User getById(UUID id);

    User getByUsername(String username);

    List<User> getAllUsers();

}
