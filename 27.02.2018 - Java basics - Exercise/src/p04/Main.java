package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        Character input = reader.readLine().charAt(0);
        if (vowels.contains(input)) {
            System.out.println("vowel");
        } else if (Character.isDigit(input)) {
            System.out.println("digit");
        }
        else{
            System.out.println("other");
        }
    }
}