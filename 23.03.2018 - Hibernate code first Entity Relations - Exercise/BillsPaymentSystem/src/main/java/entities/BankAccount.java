package entities;

import javax.persistence.*;

@Entity
@Table(name="bank_accounts")
//@DiscriminatorValue(value = "Bank Account")
@PrimaryKeyJoinColumn(name="id")
public class BankAccount extends BasicBillingDetail {
    private String name;
    private String swiftCode;

    public BankAccount() {
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="swift_code")
    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
