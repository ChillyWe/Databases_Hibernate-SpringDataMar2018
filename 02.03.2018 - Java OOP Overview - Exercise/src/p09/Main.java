package p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"end".equalsIgnoreCase(line)) {
            String name = line;
            Student student = new Student(name);
            students.add(student);
            line = reader.readLine();
        }
        if (students.size() > 0) {
            System.out.println(students.get(students.size() - 1).getStudentCounter());
        } else {
            System.out.println(0);
        }
    }
}