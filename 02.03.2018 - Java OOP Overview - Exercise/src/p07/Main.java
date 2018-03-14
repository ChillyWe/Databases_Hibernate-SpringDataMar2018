package p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Student> students = new HashMap<>();

        int numberOfStudent = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfStudent; i++) {
            String[] line = reader.readLine().split("\\s+");
            String studentName = line[0];
            List<Double> grades = Arrays.stream(line).skip(1).map(Double::valueOf).collect(Collectors.toList());
            Student student = new Student(studentName, grades);
            students.put(student.getStudentNum(), student);
        }
        List<Student> studentsSorted = students.values().stream().sorted(Comparator.comparing(Student::getName)
                                                            .thenComparing((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage())))
                .filter(s -> s.getAverage() >= 5.00).collect(Collectors.toList());
        for (Student student : studentsSorted) {
            System.out.println(String.format("%s -> %.2f", student.getName(), student.getAverage()).replace(",", "."));
        }
    }
}