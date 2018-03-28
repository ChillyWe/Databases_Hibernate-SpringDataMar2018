package entities;

import javax.persistence.*;

@Entity
@Table(name="credit_cards")
//@DiscriminatorValue(value = "Credit Card")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends BasicBillingDetail {
    private String cardType;
    private String expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Column(name="card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name= "expiration_year")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
