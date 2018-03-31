package softuni.user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.user_system.entities.User;
import softuni.user_system.service.UserService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public class Engine implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public Engine(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();


    }

    private void deleteUsersInactiveAfter(Date date) {
        List<User> users = this.userService.getAllUsersInactiveAfter(date);
        for (User user : users) {
            user.setDeleted(true);
            this.userService.save(user);
        }

        if (users.size() > 1) {
            System.out.printf("%d users have been deleted", users.size());
        } else if (users.size() == 1) {
            System.out.println("1 user has been deleted");
        } else {
            System.out.println("No users have been deleted");
        }

        for (User user : users) {
            this.userService.remove(user);
        }
    }

    private void seedDatabase() throws ParseException {
        User user = new User();

        //TODO
    }
}