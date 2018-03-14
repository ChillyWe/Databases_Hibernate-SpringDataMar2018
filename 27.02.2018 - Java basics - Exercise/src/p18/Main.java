package p18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phonebook = new TreeMap<>();

        String input;
        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            String[] commandTokens = input.split("\\s+");
            String command = commandTokens[0];
            switch (command) {
                case "A":
                    String name = commandTokens[1];
                    String phoneNumber = commandTokens[2];
                    phonebook.put(name, phoneNumber);
                    break;
                case "S":
                    name = commandTokens[1];
                    if (phonebook.containsKey(name)) {
                        System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
                    } else {
                        System.out.println(String.format("Contact %s does not exist.", name));
                    }
                    break;
                case "ListAll":
                    phonebook.forEach((key, value) -> System.out.println(String.format("%s -> %s",
                            key, value)));
                    break;
            }
        }
    }
}