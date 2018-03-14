package p04;

public class DecimalNumber {
    String decimalNumber;

    public DecimalNumber(String decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getReverseDecimalNumber () {
        StringBuilder sb = new StringBuilder(this.decimalNumber).reverse();
        return sb.toString();
    }
}