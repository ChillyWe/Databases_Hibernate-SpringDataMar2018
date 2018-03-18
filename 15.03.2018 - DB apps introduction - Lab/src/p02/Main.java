package p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3308/diablo";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection success");

            PreparedStatement user = conn.prepareStatement("select * from users where user_name LIKE (?);");
            PreparedStatement user_games = conn.prepareStatement("select * from users_games where user_id =?;");

            String name = reader.readLine();
            user.setString(1, name);

            ResultSet rs = user.executeQuery();

            if(rs.next()) {
                    int user_id = rs.getInt("id");
                    user_games.setInt(1, user_id);

                    ResultSet userGames = user_games.executeQuery();
                    int count = 0;
                    while (userGames.next()) {
                        count++;
                    }
                    System.out.println(String.format("%s %s has played %d games", rs.getString("first_name"), rs.getString("last_name"), count));
            } else {
                System.out.println("No such user exist");
            }

            conn.close();
        }
    }
}