package p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> letters = Arrays.asList(reader.readLine().split(""));

        for (int i = 0; i < letters.size(); i++) {
            int number = (int)letters.get(i).charAt(0) - 97;
            System.out.println(String.format("%s -> %d", letters.get(i), number));
        }
    }
}