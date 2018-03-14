package p13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        if (text.length() > 20) {
            text = text.substring(0, 20);
        }
        for (int i = text.length(); i < 20; i++) {
            text = text.concat("*");
        }
        System.out.println(text);
    }
}