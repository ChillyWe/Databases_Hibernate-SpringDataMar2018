package p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            Student student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            students.add(student);
        }

        students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 24)
                .forEach(student -> System.out.println(String.format("%s %s %d",
                        student.getFirstName(), student.getLastName(), student.getAge())));
    }
}


class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
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

    public int getAge() {
        return this.age;
    }
}
