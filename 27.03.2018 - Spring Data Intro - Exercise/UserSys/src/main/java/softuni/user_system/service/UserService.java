package softuni.user_system.service;

import softuni.user_system.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<User> getAllUsersInactiveAfter(Date date);

    void save(User user);

    void remove(User user);
}