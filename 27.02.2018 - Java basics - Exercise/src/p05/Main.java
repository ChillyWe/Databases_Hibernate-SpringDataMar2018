package p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bigDecimal = new BigInteger(reader.readLine());
        System.out.println(bigDecimal.toString(16).toUpperCase());
        System.out.println(bigDecimal.toString(2));

    }
}