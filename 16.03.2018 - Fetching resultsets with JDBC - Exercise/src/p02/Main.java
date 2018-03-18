package p02;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3308/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = conn.createStatement()){

           String query = "SELECT \n" +
                   "    v.name, COUNT(mv.minion_id) AS mCount\n" +
                   "FROM\n" +
                   "    villains AS v\n" +
                   "        INNER JOIN\n" +
                   "    minions_villains AS mv ON mv.villain_id = v.villain_id\n" +
                   "GROUP BY v.name\n" +
                   "HAVING mCount > 3\n" +
                   "ORDER BY mCount DESC\n" +
                   "LIMIT 3;";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println(String.format("%s %d", rs.getString("name"), rs.getInt("mCount")));
            }

            conn.close();
            statement.close();
            rs.close();
        }

    }
}