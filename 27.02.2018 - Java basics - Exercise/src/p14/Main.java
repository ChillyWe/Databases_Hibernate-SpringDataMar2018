package p14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String cryptedEmail = cryptEmail(email);

        String text = reader.readLine();

        while (text.contains(email)) {
            text = text.replace(email, cryptedEmail);
        }
        System.out.println(text);
    }

    private static String cryptEmail(String email) {
        int monkeyIndex = email.indexOf('@');
        String crypt = "";
        for (int i = 0; i < monkeyIndex; i++) {
            crypt += "*";
        }
        return crypt += email.substring(monkeyIndex, email.length());
    }
}