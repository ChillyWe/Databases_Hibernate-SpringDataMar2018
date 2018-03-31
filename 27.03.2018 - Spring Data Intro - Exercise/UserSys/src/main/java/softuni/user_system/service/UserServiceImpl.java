package softuni.user_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.user_system.entities.User;
import softuni.user_system.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsersInactiveAfter(Date date) {
        return this.userRepository.findByLastTimeLoggedInBefore(date);
    }

    @Override
    public void save(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void remove(User user) {
        this.userRepository.delete(user);
    }
}