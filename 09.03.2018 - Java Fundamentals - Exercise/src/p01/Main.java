package p01;

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
            Student student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            students.add(student);
        }

        students.stream().sorted(Comparator.comparing(Student::getFirstName))
                .filter(student -> student.getGroup() == 2)
                .forEach(student -> System.out.println(String.format("%s %s", student.getFirstName(), student.getLastName())));
    }
}


class Student {
    private String firstName;
    private String lastName;
    private int group;

    public Student(String firstName, String lastName, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getGroup() {
        return this.group;
    }
}