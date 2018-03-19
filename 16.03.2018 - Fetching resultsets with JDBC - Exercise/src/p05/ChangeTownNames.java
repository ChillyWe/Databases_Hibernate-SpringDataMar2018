package p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNames {
    private static final String URL = "jdbc:mysql://localhost:3308/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateWithUpperQ = "UPDATE towns SET name = UPPER(name) WHERE country = ?";
            String selectTownsQ = "SELECT `name` FROM towns WHERE country = ? ";
            List<String> affectedTowns = new ArrayList<>();

            PreparedStatement updateWithUpper = conn.prepareStatement(updateWithUpperQ);
            updateWithUpper.setString(1, country);
            int numberOfTowns = updateWithUpper.executeUpdate();
            updateWithUpper.close();

            if (numberOfTowns > 0) {
                System.out.println(String.format("%d town names were affected.", numberOfTowns));

                PreparedStatement selectUpdatedTowns = conn.prepareStatement(selectTownsQ);
                selectUpdatedTowns.setString(1, country);
                ResultSet rs = selectUpdatedTowns.executeQuery();

                while (rs.next()) {
                    affectedTowns.add(rs.getString("name"));
                }
                selectUpdatedTowns.close();

                System.out.println(affectedTowns.toString());

            } else {
                System.out.println("No town names were affected.");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}