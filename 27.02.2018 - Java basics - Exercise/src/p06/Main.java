package p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine().replace(" ", "");
        String s2 = reader.readLine().replace(" ", "");
        if (s1.compareTo(s2) < 0) {
            System.out.println(s1);
            System.out.println(s2);
        } else {
            System.out.println(s2);
            System.out.println(s1);
        }
    }
}