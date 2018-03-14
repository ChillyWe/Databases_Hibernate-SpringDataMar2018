package p02;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        if (Boolean.parseBoolean(text)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}