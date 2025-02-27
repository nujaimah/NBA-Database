package coe848lab5;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author nujaimah
 */
public class COE848lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        createtables();

    }

    // create all the tables in the database
    public static void createtables() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:NBAplayer.db";
            c = DriverManager.getConnection(url);
            //   System.out.println("Connection to SQLite has been established");
            stmt = c.createStatement();
//            String drop_position = "DROP TABLE position;";
//            String drop_team = "DROP TABLE team;";
//            String drop_stadium = "DROP TABLE stadium;";
//            String drop_staff = "DROP TABLE staff;";
//            String drop_player = "DROP TABLE player;";
//            String drop_gamestats = "DROP TABLE gamestats;";
//            stmt.executeUpdate(drop_position);
//            stmt.executeUpdate(drop_team);
//            stmt.executeUpdate(drop_stadium);
//            stmt.executeUpdate(drop_staff);
//            stmt.executeUpdate(drop_player);
//            stmt.executeUpdate(drop_gamestats);


            // create table for position
            String position = "CREATE TABLE position(\n" +
                                "position_name VARCHAR(255) PRIMARY KEY,\n" +
                                "position_number INTEGER NOT NULL\n" +
                                ");";            
            stmt.executeUpdate(position);
            
            // insert data into position table
            String position1 = "INSERT INTO position VALUES('Center',5);";
            String position2 = "INSERT INTO position VALUES('Shooting Guard',2);";
            String position3 = "INSERT INTO position VALUES('Point Guard',1);";
            String position4 = "INSERT INTO position VALUES('Small Forward',3);";
            String position5 = "INSERT INTO position VALUES('Power Forward',4);";      
            stmt.executeUpdate(position1);
            stmt.executeUpdate(position2);
            stmt.executeUpdate(position3);
            stmt.executeUpdate(position4);
            stmt.executeUpdate(position5);
            
            // create table for team
            String team = "CREATE TABLE team(\n"
                    + "team_name VARCHAR(255) PRIMARY KEY,\n"
                    + "year_created INTEGER NOT NULL,\n"
                    + "no_of_championships INTEGER NOT NULL,\n"
                    + "stadium_name VARCHAR(255) NOT NULL,\n"
                    + "CONSTRAINT fk_stadium FOREIGN KEY (stadium_name) REFERENCES stadium (stadium_name)\n"
                    + ");";
            stmt.executeUpdate(team);
            
            // insert data into team table
            String team1 = "INSERT INTO team VALUES('Toronto Raptors',1995,1,'Scotiabank Arena');";
            String team2 = "INSERT INTO team VALUES('Chicago Bulls',1966,6,'United Center');";
            String team3 = "INSERT INTO team VALUES('Los Angeles Lakers',1948,17,'Crypto.com Arena');";
            String team4 = "INSERT INTO team VALUES('Boston Celtics',1946,17,'TD Garden');";
            String team5 = "INSERT INTO team VALUES('Miami Heat',1988,3,'Miami-Dade Arena');";
            String team6 = "INSERT INTO team VALUES('Cleveland Cavaliers',1970,1,'Rocket Mortgage FieldHouse');";
            String team7 = "INSERT INTO team VALUES('Milwaukee Bucks',1968,2,'Fisery Forum');";
            String team8 = "INSERT INTO team VALUES('New York Knicks',1946,2,'Madison Square Garden');";
            String team9 = "INSERT INTO team VALUES('Philadelphia 76ers',1949,3,'Wells Fargo Center');";
            String team10 = "INSERT INTO team VALUES('Golden State Warriors',1946,7,'Chase Center');";
            stmt.executeUpdate(team1);
            stmt.executeUpdate(team2);
            stmt.executeUpdate(team3);
            stmt.executeUpdate(team4);
            stmt.executeUpdate(team5);
            stmt.executeUpdate(team6);
            stmt.executeUpdate(team7);
            stmt.executeUpdate(team8);
            stmt.executeUpdate(team9);
            stmt.executeUpdate(team10);
    
            // create table for stadium
            String stadium = "CREATE TABLE stadium(\n"
                    + "stadium_name VARCHAR(255) PRIMARY KEY,\n"
                    + "stadium_address VARCHAR(255) NOT NULL\n"
                    + ");";
            stmt.executeUpdate(stadium);

            // insert data into stadium table
            String stadium1 = "INSERT INTO stadium VALUES('Scotiabank Arena','40 Bay Street');";
            String stadium2 = "INSERT INTO stadium VALUES('United Center','1901 West Madison Street');";
            String stadium3 = "INSERT INTO stadium VALUES('Crypto.com Arena','1111 South Figueroa Street');";
            String stadium4 = "INSERT INTO stadium VALUES('TD Garden','100 Legends Way');";
            String stadium5 = "INSERT INTO stadium VALUES('Miami-Dade Arena','601 Biscayne Boulevard');";
            String stadium6 = "INSERT INTO stadium VALUES('Rocket Mortgage FieldHouse','1 Center Court');";
            String stadium7 = "INSERT INTO stadium VALUES('Fisery Forum','1111 Vel R. Phillips Avenue');";
            String stadium8 = "INSERT INTO stadium VALUES('Madison Square Garden','4 Pennsylvania Plaza');";
            String stadium9 = "INSERT INTO stadium VALUES('Wells Fargo Center','3601 South Broad Street');";
            String stadium10 = "INSERT INTO stadium VALUES('Chase Center','1 Warriors Way');";
            stmt.executeUpdate(stadium1);
            stmt.executeUpdate(stadium2);
            stmt.executeUpdate(stadium3);
            stmt.executeUpdate(stadium4);
            stmt.executeUpdate(stadium5);
            stmt.executeUpdate(stadium6);
            stmt.executeUpdate(stadium7);
            stmt.executeUpdate(stadium8);
            stmt.executeUpdate(stadium9);
            stmt.executeUpdate(stadium10);
            
            // create table for staff
            String staff = "CREATE TABLE staff(\n"
                    + "staffID INTEGER PRIMARY KEY,\n"
                    + "staff_name VARCHAR(255) NOT NULL,\n"
                    + "staff_type VARCHAR(255) NOT NULL,\n"
                    + "team_name VARCHAR(255) NOT NULL,\n"
                    + "CONSTRAINT fk_team FOREIGN KEY (team_name) REFERENCES team (team_name)\n"
                    + ");";
            stmt.executeUpdate(staff);
            
            // insert data into staff table
            String staff1 = "INSERT INTO staff VALUES(1,'Joe Lacob','Owner','Golden State Warriors');";
            String staff2 = "INSERT INTO staff VALUES(2,'Bob Myers','General Manager','Golden State Warriors');";
            String staff3 = "INSERT INTO staff VALUES(3,'Steve Kerr','Head Coach','Golden State Warriors');";
            String staff4 = "INSERT INTO staff VALUES(4,'Maple Leafs Sports and Entertainment','Owner','Toronto Raptors');";
            String staff5 = "INSERT INTO staff VALUES(5,'Masai Ujiri','General Manager','Toronto Raptors');";
            String staff6 = "INSERT INTO staff VALUES(6,'Nick Nurse','Head Coach','Toronto Raptors');";
            String staff7 = "INSERT INTO staff VALUES(7,'Joshua Harris','Owner','Philadelphia 76ers');";
            String staff8 = "INSERT INTO staff VALUES(8,'Elton Brand','General Manager','Philadelphia 76ers');";
            String staff9 = "INSERT INTO staff VALUES(9,'Doc Rivers','Head Coach','Philadelphia 76ers');";
            String staff10 = "INSERT INTO staff VALUES(10,'Jerry Reinsdor','Owner','Chicago Bulls');";
            stmt.executeUpdate(staff1);
            stmt.executeUpdate(staff2);
            stmt.executeUpdate(staff3);
            stmt.executeUpdate(staff4);
            stmt.executeUpdate(staff5);
            stmt.executeUpdate(staff6);
            stmt.executeUpdate(staff7);
            stmt.executeUpdate(staff8);
            stmt.executeUpdate(staff9);
            stmt.executeUpdate(staff10);
            
            // create table for player
            String player = "CREATE TABLE player(\n"
                    + "playerID INTEGER PRIMARY KEY,\n"
                    + "first_name VARCHAR(255) NOT NULL,\n"
                    + "last_name VARCHAR(255) NOT NULL,\n"
                    + "birth_place VARCHAR(255) NOT NULL,\n"
                    + "birthday VARCHAR(255) NOT NULL,\n"
                    + "height VARCHAR(255) NOT NULL,\n"
                    + "college_attended VARCHAR(255) NOT NULL,\n"
                    + "statsID INTEGER NOT NULL,\n"
                    + "team_name VARCHAR(255) NOT NULL,\n"
                    + "position_name VARCHAR(255) NOT NULL, age INTEGER, experience integer,\n"         
                    + "CONSTRAINT fk_stat FOREIGN KEY (statsID) REFERENCES gamestats (statsID),\n"
                    + "CONSTRAINT fk_team FOREIGN KEY (team_name) REFERENCES team (team_name),\n"
                    + "CONSTRAINT fk_position FOREIGN KEY (position_name) REFERENCES position (position_name)\n"
                    + ");";
            stmt.executeUpdate(player);
      
            // insert data into player table
            String player1 = "INSERT INTO player VALUES(1,'Pascal','Siakam','Cameroon','April 2 1994','6 ft 8','New Mexico State',1,'Toronto Raptors','Power Forward',28,6);";
            String player2 = "INSERT INTO player VALUES(2,'Kyle','Lowry','USA','March 25 1986','6 ft 0','Villanova',2,'Miami Heat','Point Guard',36,16);";
            String player3 = "INSERT INTO player VALUES(3,'Demar','Derozan','USA','August 7 1989','6 ft 6','Southern California',3,'Chicago Bulls','Power Forward',33,13);";
            String player4 = "INSERT INTO player VALUES(4,'Lebron','James','USA','December 30 1984','6 ft 9','St. Vincent Mary',4,'Los Angeles Lakers','Shooting Guard',38,19);";
            String player5 = "INSERT INTO player VALUES(5,'Scottie','Barnes','USA','August 1 2001','6 ft 8','Florida State',5,'Toronto Raptors','Small Forward',21,1);";
            String player6 = "INSERT INTO player VALUES(6,'Stephen','Curry','USA','March 14 1988','6 ft 2','Davidson',6,'Golden State Warriors','Point Guard',35,13);";
            String player7 = "INSERT INTO player VALUES(7,'Giannis','Antetekounmpo','Greece','December 6 1994','7 ft 0','Flathlitikos',7,'Milwaukee Bucks','Center',28,9);";
            String player8 = "INSERT INTO player VALUES(8,'Jayson','Tatum','USA','March 3 1998','6 ft 8','Duke',8,'Boston Celtics','Shooting Guard',25,5);";
            String player9 = "INSERT INTO player VALUES(9,'Tyrese','Maxey','USA','November 4 2000','6 ft 2','Kentucky',9,'Philadelphia 76ers','Small Forward',22,2);";
            String player10 = "INSERT INTO player VALUES(10,'RJ','Barrett','Canada','June 14 2000','6 ft 6','Duke',10,'New York Knicks','Power Forward',22,3);";
            stmt.executeUpdate(player1);
            stmt.executeUpdate(player2);
            stmt.executeUpdate(player3);
            stmt.executeUpdate(player4);
            stmt.executeUpdate(player5);
            stmt.executeUpdate(player6);
            stmt.executeUpdate(player7);
            stmt.executeUpdate(player8);
            stmt.executeUpdate(player9);
            stmt.executeUpdate(player10);

            // create table for game stats
            String gamestats = "CREATE TABLE gamestats(\n"
                    + "statsID INTEGER PRIMARY KEY,\n"
                    + "FG INTEGER NOT NULL,\n"
                    + "points_per_game INTEGER NOT NULL,\n"
                    + "rebounds_per_game INTEGER NOT NULL,\n"
                    + "assists_per_game INTEGER NOT NULL,\n"
                    + "minutes_played INTEGER NOT NULL,\n"
                    + "FT INTEGER NOT NULL\n"
                    + ");";
            stmt.executeUpdate(gamestats);
            
            // insert data into game stats table
            String gamestats1 = "INSERT INTO gamestats VALUES(1,47.299999999999995381,24.399999999999999467,7.5999999999999996447,5.9000000000000003552,37.5,77.200000000000006394);";
            String gamestats2 = "INSERT INTO gamestats VALUES(2,39.899999999999998578,11.899999999999999467,4.2000000000000001776,5.2000000000000001776,33,85);";
            String gamestats3 = "INSERT INTO gamestats VALUES(3,50.899999999999998578,25,4.5999999999999996447,5.0999999999999996447,36.200000000000001065,86.600000000000001421);";
            String gamestats4 = "INSERT INTO gamestats VALUES(4,50.099999999999997868,25.899999999999998578,8.4000000000000003552,6.9000000000000003552,36.100000000000003197,75.90000000000000746);";
            String gamestats5 = "INSERT INTO gamestats VALUES(5,45.200000000000004618,15.600000000000000532,7,4.7999999999999998223,35.299999999999998046,77.200000000000006394);";
            String gamestats6 = "INSERT INTO gamestats VALUES(6,49.700000000000006394,29.599999999999999644,6.2999999999999998223,6.2999999999999998223,34.700000000000001953,92.200000000000006394);";
            String gamestats7 = "INSERT INTO gamestats VALUES(7,54.299999999999997157,31.499999999999999111,11.899999999999999467,5.5,32.5,65.599999999999996092);";
            String gamestats8 = "INSERT INTO gamestats VALUES(8,46.100000000000003197,30.300000000000002486,8.9000000000000003552,4.7999999999999998223,37.39999999999999769,86);";
            String gamestats9 = "INSERT INTO gamestats VALUES(9,46.799999999999997157,19.80000000000000071,2.7000000000000001776,3.3999999999999999111,32.900000000000000355,83.399999999999998578);";
            String gamestats10 = "INSERT INTO gamestats VALUES(10,43,19.80000000000000071,5.2000000000000001776,2.7000000000000001776,34.20000000000000373,74.599999999999990762);";
            stmt.executeUpdate(gamestats1);
            stmt.executeUpdate(gamestats2);
            stmt.executeUpdate(gamestats3);
            stmt.executeUpdate(gamestats4);
            stmt.executeUpdate(gamestats5);
            stmt.executeUpdate(gamestats6);
            stmt.executeUpdate(gamestats7);
            stmt.executeUpdate(gamestats8);
            stmt.executeUpdate(gamestats9);
            stmt.executeUpdate(gamestats10);
            
            stmt.close();
            c.close();
            menu();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // main menu with options
    public static void menu() {
        System.out.println("\nWelcome to NBA player database application:");
        System.out.println("To see the current players over the age of 25, type 1");
        System.out.println("To see the current players who have played for the NBA for less than 5 years, type 2");
        System.out.println("To see the current players who are 6 ft. 8, type 3");
        System.out.println("To see the current players who are from Canada, type 4");
        System.out.println("To see the current player who is averaging the most assists, type 5");
        System.out.println("To see the current player who is averaging the most points, type 6");
        System.out.println("To see the current player who is averaging the most rebounds, type 7");
        System.out.println("To see the current players who are averaging over 20 points this season, type 8");
        System.out.println("To see the current players who went to the University of Southern California, type 9");
        System.out.println("To see the current players who are averaging more than 35 minutes per game, type 10");
        System.out.println("To exit the program, type 0");

        // get user input
        Scanner myObj = new Scanner(System.in);
        int input = myObj.nextInt();
        System.out.println("\n");

        // call queries
        query(input);
    }

    public static void query(int n) {
        // check user input value and do select queries based on input
        if (n == 1) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, age FROM player where age > 25");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String playerAge = rs.getString("age");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + playerAge);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 2) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, experience FROM player where experience < 5");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String playerExperience = rs.getString("experience");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + playerExperience);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 3) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, height FROM player where height = '6 ft 8';");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String playerHeight = rs.getString("height");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + playerHeight);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

        } else if (n == 4) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, birth_place FROM player where birth_place = 'Canada';");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String playerBirth = rs.getString("birth_place");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + playerBirth);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 5) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, MAX(assists_per_game) FROM player, gamestats where gamestats.statsID = player.statsID;");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String assists = rs.getString("MAX(assists_per_game)");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + assists);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 6) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, MAX(points_per_game) FROM player, gamestats where gamestats.statsID = player.statsID;");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String points = rs.getString("MAX(points_per_game)");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + points);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 7) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, MAX(rebounds_per_game) FROM player, gamestats where gamestats.statsID = player.statsID;");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String rebounds = rs.getString("MAX(rebounds_per_game)");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + rebounds);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 8) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, points_per_game FROM player, gamestats where gamestats.statsID = player.statsID AND points_per_game > 20;");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String points = rs.getString("points_per_game");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + points);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 9) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, college_attended FROM player where college_attended = 'Southern California';");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String college = rs.getString("college_attended");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + college);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (n == 10) {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:NBAplayer.db";
                c = DriverManager.getConnection(url);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT playerID, first_name, last_name, minutes_played FROM player, gamestats where gamestats.statsID = player.statsID AND minutes_played > 35;");
                while (rs.next()) {
                    String playerID = rs.getString("playerID");
                    String playerFirst = rs.getString("first_name");
                    String playerLast = rs.getString("last_name");
                    String minutes = rs.getString("minutes_played");
                    System.out.println(playerID + "\t" + playerFirst + "\t" + playerLast + "\t" + minutes);
                }
                stmt.close();
                c.close();
                System.out.println("Returning to main menu...");
                menu();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else {
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }
}
         
