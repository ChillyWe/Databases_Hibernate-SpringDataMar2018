package p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3308/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String getMinionsByVillainQuery = "SELECT m.name, " +
                    "m.age FROM minions as m " +
                    "JOIN minions_villains as mv ON m.minion_id = mv.minion_id " +
                    "WHERE villain_id = ? ";
            String getVillainsNameQuery = "SELECT name FROM villains WHERE villain_id = ? ";

            PreparedStatement getMinionsByVillainStmnt = conn.prepareStatement(getMinionsByVillainQuery);
            getMinionsByVillainStmnt.setInt(1, id);
            ResultSet minions = getMinionsByVillainStmnt.executeQuery();

            PreparedStatement getVillainsNameStmnt = conn.prepareStatement(getVillainsNameQuery);
            getVillainsNameStmnt.setInt(1, id);
            ResultSet villainName = getVillainsNameStmnt.executeQuery();

            if (!villainName.next()) {
                System.out.printf("No villain with ID %d exists in the database.%n", id);
            } else {
                System.out.printf("Villain: %s%n", villainName.getString("name"));
            }
            getVillainsNameStmnt.close();
            int count = 0;

            while (minions.next()) {
                count++;
                System.out.printf("%d. %s %d%n", count, minions.getString("name"),
                        minions.getInt("age"));
            }

            getMinionsByVillainStmnt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}