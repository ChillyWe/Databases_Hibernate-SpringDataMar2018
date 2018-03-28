package entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="savings_accounts")
public class SavingsAccount extends BankAccount {
    private BigDecimal fee;

    public SavingsAccount() {
    }

    @Basic
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void deductFee(){
        super.setBalance(
                super.getBalance().subtract(this.fee)
        );
    }
}
