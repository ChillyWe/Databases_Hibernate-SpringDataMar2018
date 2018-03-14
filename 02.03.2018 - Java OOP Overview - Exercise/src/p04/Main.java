package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String decimalNumber = reader.readLine();
        DecimalNumber dn = new DecimalNumber(decimalNumber);
        System.out.println(dn.getReverseDecimalNumber());
    }
}