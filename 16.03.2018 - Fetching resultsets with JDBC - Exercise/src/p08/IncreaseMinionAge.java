package p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class IncreaseMinionAge {
    private static final String URL = "jdbc:mysql://localhost:3308/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] minionsID = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String selectMinionQ = "SELECT m.name AS minionName, m.age AS minionAge FROM minions AS m WHERE m.minion_id = ?;";
        String updateMinionQ = "UPDATE minions SET name = ?, age = ? WHERE minion_id = ?";
        String selectAllMinions = "SELECT m.name AS minionName, m.age AS minionAge FROM minions AS m";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (minionsID.length > 0) {
                for (int i = 0; i < minionsID.length; i++) {
                    int id = minionsID[i];

                    PreparedStatement selectMinionWithID = conn.prepareStatement(selectMinionQ);
                    selectMinionWithID.setInt(1, id);
                    ResultSet minionResult = selectMinionWithID.executeQuery();

                    if (minionResult.next()) {
                        String name = minionResult.getString("minionName").toUpperCase();
                        int age = minionResult.getInt("minionAge");

                        name = NameCreator(name);
                        age += 1;

                        PreparedStatement updateMinion = conn.prepareStatement(updateMinionQ);
                        updateMinion.setString(1, name);
                        updateMinion.setInt(2, age);
                        updateMinion.setInt(3, id);
                        updateMinion.executeUpdate();

                        String debug = "";
                        minionResult.close();
                        updateMinion.close();
                    } else {
                        System.out.println(String.format("There is no minion with ID = %d", id));
                    }
                }
            }

            PreparedStatement allMinions = conn.prepareStatement(selectAllMinions);
            ResultSet allMinionsResult = allMinions.executeQuery();
            while (allMinionsResult.next()) {
                System.out.println(String.format("%s %d", allMinionsResult.getString("minionName"), allMinionsResult.getInt("minionAge")));
            }

            allMinionsResult.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static String NameCreator(String name) {
        if (name.contains(" ")) {
            int space = name.indexOf(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(name.charAt(0)).append(name.substring(1, space).toLowerCase()).append(" ")
                    .append(name.charAt(space + 1)).append(name.substring(space + 2, name.length()).toLowerCase());
            name = sb.toString();
        } else {
            name = name.charAt(0) + name.substring(1, name.length()).toLowerCase();
        }
        return name;
    }
}