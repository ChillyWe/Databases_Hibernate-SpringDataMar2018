package p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            int[] grades = Arrays.stream(tokens).skip(2).mapToInt(Integer::parseInt).toArray();
            Student student = new Student(tokens[0], tokens[1], grades);
            students.add(student);
        }

        students.stream()
                .filter(Student::checkForExcellentMark)
                .forEach(student -> System.out.println(String.format("%s %s",
                        student.getFirstName(), student.getLastName())));
    }
}

class Student {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String firstName, String lastName, int[] grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new ArrayList<>();
        this.setGrades(grades);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean checkForExcellentMark() {
        for (Integer grade : grades) {
            if (grade == 6) {
                return true;
            }
        }
        return false;
    }

    private void setGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            int mark = grades[i];
            if (mark >= 2 && mark <= 6) {
                this.grades.add(mark);
            }
        }
    }
}