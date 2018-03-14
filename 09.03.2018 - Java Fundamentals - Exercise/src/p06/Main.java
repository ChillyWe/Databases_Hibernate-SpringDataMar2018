package p06;

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
            Student student = new Student(tokens[0], tokens[1], tokens[2]);
            students.add(student);
        }

        students.stream()
                .filter(student -> student.getPhone().startsWith("02") || student.getPhone().startsWith("+3592"))
                .forEach(student -> System.out.println(String.format("%s %s",
                        student.getFirstName(), student.getLastName())));
    }
}

class Student {
    private String firstName;
    private String lastName;
    private String phone;

    public Student(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }
}