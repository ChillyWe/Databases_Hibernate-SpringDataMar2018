package p09;

public class Student {
    private static int studentCounter = 0;
    private String name;

    public Student(String name) {
        this.name = name;
        studentCounter++;
    }

    public int getStudentCounter() {
        return studentCounter;
    }
}