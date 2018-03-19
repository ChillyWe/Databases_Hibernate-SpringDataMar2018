//        DELIMITER ^^
//        CREATE PROCEDURE usp_get_older(id INT)
//        BEGIN
//        UPDATE minions SET age = age+1 WHERE minion_id = id;
//        END ^^
//
//        DELIMITER ;

package p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputId = Integer.parseInt(reader.readLine());

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String procedure = "CALL usp_get_older(?)";
            String selectQuery = "SELECT * FROM minions WHERE minion_id = ?";

            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, inputId);
            ResultSet result = selectStmt.executeQuery();

            if (result.next()) {
                CallableStatement callableStatement = conn.prepareCall(procedure);
                callableStatement.setInt(1, inputId);
                callableStatement.execute();
                callableStatement.close();

                ResultSet resultUpdated = selectStmt.executeQuery();
                if (resultUpdated.next()) {
                    System.out.printf("%s %d%n", resultUpdated.getString("name"), resultUpdated.getInt("age"));
                }
                selectStmt.close();
            } else {
                System.out.println("No minion with that id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}