package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 18.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Smartphone phone = new Smartphone();

        String[] numbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        for (String number : numbers) {
            System.out.println(phone.call(number));
        }

        for (String url : urls) {
            System.out.println(phone.browse(url));
        }
    }
}