package p03;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Character firstLetter = reader.readLine().charAt(0);
        Character secondLetter = reader.readLine().charAt(0);
        Character thirdLetter = reader.readLine().charAt(0);

        System.out.print(thirdLetter);
        System.out.print(secondLetter);
        System.out.print(firstLetter);
    }
}