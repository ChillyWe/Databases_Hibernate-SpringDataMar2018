package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        if (repository.exists(id) && (repository.findOne(id).getBalance().compareTo(new BigDecimal("0")) > 0)) {
            BigDecimal balance = repository.findOne(id).getBalance();
            balance = balance.subtract(money);
            repository.findOne(id).setBalance(balance);
            repository.save(repository.findOne(id));
        }
        else {
            throw new IllegalArgumentException("Account doesn't exist or balance is not enough");
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {

    }
}
