import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import services.AccountServiceImpl;
import services.UserServiceImpl;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("mastero");
        user.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal("25000"));

        user.getAccounts().add(account);
        userService.registerUser(user);

        accountService.withdrawMoney(new BigDecimal("20000"), account.getId());
    }
}