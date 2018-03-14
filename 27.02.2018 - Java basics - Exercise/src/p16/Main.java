package p16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<upcase>(.*?)<\\/upcase>");

        String text = reader.readLine();
        String result = text;
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group(1);
            String fullMatch = matcher.group(0);
            result = result.replace(fullMatch, match.toUpperCase());
        }
        System.out.println(result);
    }
}