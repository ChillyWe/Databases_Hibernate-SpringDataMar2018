package p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3308/soft_uni";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection success");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE salary > ?");
            String salary = reader.readLine();
            stmt.setDouble(1, Double.parseDouble(salary));

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }


            String debug = "";
        }
    }
}