package p15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        String text = reader.readLine();
        String protocol = "";
        if (text.contains("://")) {
            String[] firstPart = text.split("://");
            protocol = firstPart[0];
            text = text.substring(protocol.length() + 3, text.length());
        }
        result.append(String.format("[protocol] = \"%s\"", protocol)).append(System.lineSeparator());

        String server = text;
        String resources = "";
        if (text.contains("/")) {
            String[] secondPartArray = text.split("/");
            server = secondPartArray[0];
            resources = text.substring(server.length() + 1, text.length());
        }
        result.append(String.format("[server] = \"%s\"", server)).append(System.lineSeparator())
                .append(String.format("[resource] = \"%s\"", resources));
        System.out.println(result);
    }
}