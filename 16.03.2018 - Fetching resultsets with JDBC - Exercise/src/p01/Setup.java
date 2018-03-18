package p01;

import java.sql.*;

public class Setup {
    private static final String URL ="jdbc:mysql://localhost:3308";
    private static final String USER = "root";
    private static final String PASSWORD = "1919";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmnt = conn.createStatement()){
            String createQuery = "CREATE DATABASE IF NOT EXISTS minions_db;";
            String useQuery = "USE minions_db";
            String minionsQuery = "CREATE TABLE IF NOT EXISTS minions( " +
                    "minion_id INT AUTO_INCREMENT PRIMARY KEY, "+
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT, " +
                    "town_id INT, " +
                    "CONSTRAINT fk_towns_minions FOREIGN KEY (town_id) REFERENCES  towns(town_id) " +
                    "); " ;
            String townsQuery = "CREATE TABLE IF NOT EXISTS towns( " +
                    "town_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "country VARCHAR(50)); ";

            String villainsQuery = "CREATE TABLE IF NOT EXISTS villains( " +
                    "villain_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "evilness_factor VARCHAR(20));";
            String minionsVillainsQuery =
                    "CREATE TABLE IF NOT EXISTS minions_villains( " +
                            "minion_id INT, " +
                            "villain_id INT, " +
                            "CONSTRAINT pk_minions_villains PRIMARY KEY (minion_id, villain_id), " +
                            "CONSTRAINT fk_minions_villains_minions FOREIGN KEY (minion_id) REFERENCES minions(minion_id), " +
                            "CONSTRAINT fk_minions_villains_villains FOREIGN KEY (villain_id) REFERENCES villains(villain_id)); ";

            String insertTownsQuery = "INSERT INTO towns(name, country) " +
                    "VALUES ('Paris', 'France'), ('Moscow', 'Russia'),('Kiev', 'Ukraine')," +
                    "('Zagreb', 'Croatia'), ('Sofia','Bulgaria'), ('Plovdiv','Bulgaria'); ";


            String insertMinionsQuery = "INSERT INTO minions(name, age, town_id) " +
                    "VALUES ('Kevin', 12, 3), ('Maq', 18, 5), ('Stewart', 101, 2), " +
                    "('Bob', 67, 4), ('Pesho', 42, 6), ('Robin', 27, 1); ";

            String insertVillainsQuery = "INSERT INTO villains(name, evilness_factor) " +
                    "VALUES ('Zlobiul', 'super evil'), ('BadBoy', 'super evil'), ('Gadnio', 'evil'), " +
                    "('Evil4o', 'bad'), ('Drunkan', 'good'); ";
            String insertVillainsMinionsQuery = "INSERT INTO minions_villains(minion_id, villain_id) " +
                    "VALUES (1,1), (4,1), (3,2), (5,2), (6,4), (5,4), (1,5), " +
                    "(3,5), (2,5), (4,5), (5,5), (2,1), (3,1); ";

            stmnt.executeUpdate(createQuery);
            stmnt.executeQuery(useQuery);
            stmnt.executeUpdate(townsQuery);
            stmnt.executeUpdate(minionsQuery);
            stmnt.executeUpdate(villainsQuery);
            stmnt.executeUpdate(minionsVillainsQuery);
            stmnt.executeUpdate(insertTownsQuery);
            stmnt.executeUpdate(insertMinionsQuery);
            stmnt.executeUpdate(insertVillainsQuery);
            stmnt.executeUpdate(insertVillainsMinionsQuery);
        }
    }
}