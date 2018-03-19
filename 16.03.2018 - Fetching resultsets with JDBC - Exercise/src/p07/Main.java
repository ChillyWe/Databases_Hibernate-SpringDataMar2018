package p07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3308/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) {
        String query = "SELECT name FROM minions";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement takeMinionsName = conn.prepareStatement(query);
            ResultSet rs = takeMinionsName.executeQuery();
            List<String> names = new ArrayList<>();

            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            for (int i = 0, j = names.size() - 1; i < names.size() / 2; i++, j--) {
                System.out.println(names.get(i));
                System.out.println(names.get(j));
            }
            if (names.size() % 2 != 0) {
                System.out.println(names.get(names.size() / 2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}