package p07;

import java.util.List;

public class Student {
    private static int studentNum = 0;
    private String name;
    private List<Double> studentGrades;

    public Student(String name, List<Double> grades) {
        studentNum++;
        this.name = name;
        this.studentGrades = grades;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public double getAverage() {
        double average = 0d;
        for (Double studentGrade : this.studentGrades) {
            average += studentGrade;
        }
        return average / this.studentGrades.size();
    }
}