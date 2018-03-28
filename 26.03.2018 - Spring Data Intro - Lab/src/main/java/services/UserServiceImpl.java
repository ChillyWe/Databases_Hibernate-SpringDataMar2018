package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(User user) {
        if (!repository.exists(user.getId())) {
            repository.save(user);
        } else {
            throw new IllegalArgumentException("user is already exist");
        }
    }
}
