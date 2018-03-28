package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "checking_accounts")
public class CheckingAccount extends BankAccount {
    private BigDecimal interestRate;

    public CheckingAccount() {
    }

    @Column(name="interest_rate")
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(){
        super.setBalance(
                super.getBalance().add(
                        super.getBalance().multiply(this.interestRate).divide(BigDecimal.valueOf(100))
        ));
    }
}
