package p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Person>> persons = new TreeMap<>();

        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);
            Person person = new Person(name, group);
            if (!persons.containsKey(group)) {
                persons.put(person.getGroup(), new ArrayList<>());
            }
            persons.get(group).add(person);
        }
        persons.forEach((key, value) -> System.out.println(String.format("%d - %s", key,
                String.join(", ", value.toString()))
                .replace("[", "")
                .replace("]", "")));
    }
}