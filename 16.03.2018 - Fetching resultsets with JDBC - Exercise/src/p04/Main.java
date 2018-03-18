package p04;

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
        String[] minionInfo = reader.readLine().split("\\s");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String[] villainInfo = reader.readLine().split("\\s");
        String villainName = villainInfo[1];

        String selectTownQuery = "SELECT * FROM towns WHERE name = ? ";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ? ";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ? ";

        String insertTownQuery = "INSERT INTO towns(name) VALUE (?) ";
        String insertVillainQuery = "INSERT INTO villains(name,evilness_factor) VALUE (?,'evil')";

        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUE (?,?,?)";
        String insertMapTableQuery = "INSERT INTO minions_villains(minion_id, villain_id) VALUE(?,?) ";


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement selectTownStmnt = conn.prepareStatement(selectTownQuery);
            selectTownStmnt.setString(1,minionTown);
            ResultSet townResult = selectTownStmnt.executeQuery();

            if(!townResult.next()){
                PreparedStatement insertTownStmnt = conn.prepareStatement(insertTownQuery);
                insertTownStmnt.setString(1, minionTown);
                insertTownStmnt.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", minionTown);
                insertTownStmnt.close();
            }

            int townId = 0;
            ResultSet townResultUpdated = selectTownStmnt.executeQuery();

            if(townResultUpdated.next()){
                townId = townResultUpdated.getInt("town_id");
            }
            selectTownStmnt.close();

            PreparedStatement selectVillainStmnt = conn.prepareStatement(selectVillainQuery);
            selectVillainStmnt.setString(1,villainName);
            ResultSet villainResult = selectVillainStmnt.executeQuery();

            if(!villainResult.next()){
                PreparedStatement insertVillainStmnt = conn.prepareStatement(insertVillainQuery);
                insertVillainStmnt.setString(1, villainName);
                insertVillainStmnt.executeUpdate();
                System.out.printf("Villain %s was added to the database.\n", villainName);
                insertVillainStmnt.close();
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStmnt.executeQuery();

            if(villainResultUpdated.next()){
                villainId = villainResultUpdated.getInt("villain_id");
            }
            selectVillainStmnt.close();

            PreparedStatement insertMinionStmnt = conn.prepareStatement(insertMinionQuery);
            insertMinionStmnt.setString(1,minionName);
            insertMinionStmnt.setInt(2,minionAge);
            insertMinionStmnt.setInt(3,townId);
            insertMinionStmnt.executeUpdate();
            insertMinionStmnt.close();

            int minionId = 0;
            PreparedStatement selectMinionStmnt = conn.prepareStatement(selectMinionQuery);
            selectMinionStmnt.setString(1,minionName);
            ResultSet minion = selectMinionStmnt.executeQuery();
            if(minion.next()){
                minionId = minion.getInt("minion_id");
            }
            selectMinionStmnt.close();

            PreparedStatement insertMapTableStmnt = conn.prepareStatement(insertMapTableQuery);
            insertMapTableStmnt.setInt(1,minionId);
            insertMapTableStmnt.setInt(2,villainId);
            insertMapTableStmnt.executeUpdate();
            insertMapTableStmnt.close();
            System.out.printf("Successfully added %s to be minion of %s.\n", minionName, villainName);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}