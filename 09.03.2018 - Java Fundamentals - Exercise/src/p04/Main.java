package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            Student student = new Student(tokens[0], tokens[1]);
            students.add(student);
        }

        students.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName())))
                .forEach(student -> System.out.println(String.format("%s %s",
                        student.getFirstName(), student.getLastName())));
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}