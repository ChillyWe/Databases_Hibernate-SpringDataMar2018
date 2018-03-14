package p03;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public String getNumber() {
        int lastDigit = this.number % 10;
        return getStringNumber(lastDigit);
    }

    private String getStringNumber(int lastDigit) {
        String lastDigitString = "";
        switch (lastDigit) {
            case 0:
                lastDigitString = "zero";
                break;
            case 1:
                lastDigitString = "one";
                break;
            case 2:
                lastDigitString = "two";
                break;
            case 3:
                lastDigitString = "three";
                break;
            case 4:
                lastDigitString = "four";
                break;
            case 5:
                lastDigitString = "five";
                break;
            case 6:
                lastDigitString = "six";
                break;
            case 7:
                lastDigitString = "seven";
                break;
            case 8:
                lastDigitString = "eight";
                break;
            case 9:
                lastDigitString = "nine";
                break;
        }
        return lastDigitString;
    }
}