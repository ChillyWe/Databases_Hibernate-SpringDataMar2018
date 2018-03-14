package p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> studentsWithGrades = new LinkedHashMap<>();

        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String facNumber = tokens[0];
            List<Integer> grades = Arrays.stream(tokens).skip(1)
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            studentsWithGrades.put(facNumber, grades);
        }

        studentsWithGrades.entrySet().stream().filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(String.join(" ", s.getValue().toString())
                        .replace("[", "")
                        .replace(",", "")
                        .replace("]", "")));
    }
}