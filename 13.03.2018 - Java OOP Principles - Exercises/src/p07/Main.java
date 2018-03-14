package p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 31.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] studentTokens = reader.readLine().split("\\s+");
            Human student = new Student(studentTokens[0], studentTokens[1], studentTokens[2]);
            String[] workerTokens = reader.readLine().split("\\s+");
            Human worker = new Worker(workerTokens[0], workerTokens[1], Double.parseDouble(workerTokens[2]), Double.parseDouble(workerTokens[3]));
            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}