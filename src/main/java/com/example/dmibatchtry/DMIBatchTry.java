package com.example.dmibatchtry;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;


public class DMIBatchTry {
    public static <Counter> void main(String[] args) throws SQLException {
/*
        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Station;");
            ResultSet rs = ps.executeQuery();

            boolean isDuplicate = false;

            while (rs.next()) {
                if (Objects.equals(Station.getStationID(), rs.getInt("StationID"))) {
                    isDuplicate = true;
                    System.out.println(weatherStation.getStationName() + " is already in database");
                    break;
                }
            }


            if (!isDuplicate) {

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO Station VALUES (?,?,?,?,?)");
                conn.setAutoCommit(false);
                Scanner sc = new Scanner(new File("C:\\Users\\chris\\IdeaProjects\\DMIBatchTry\\src\\main\\resources\\com\\example\\dmibatchtry\\StationTableData.txt"));
                sc.useDelimiter("\t");   //sets the delimiter pattern

                while (sc.hasNext())  //returns a boolean value
                {
                    for (int i = 0; i < 5; i++) {
                        // System.out.println("test" + sc.next());
                        stmt.setInt(1, Integer.parseInt(sc.next()));
                        stmt.setString(2, sc.next());
                        stmt.setString(3, sc.next());
                        stmt.setString(4, sc.next());
                        stmt.setString(5, sc.next());
                        // System.out.println("test1" + sc.next());
                        stmt.addBatch();
                        if (i == 5) {
                            System.out.println();
                        }
                        //System.out.print(sc.next());

                        sc.close();
                        stmt.executeBatch();
                        conn.commit();

                    }
                }
            }
        }
                 catch(Exception e){
                        e.printStackTrace();

                    }


    }
}*/

        int counter = 0;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO WeatherData VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            conn.setAutoCommit(false);
            Scanner sc = new Scanner(new File("C:\\Users\\chris\\IdeaProjects\\DMIBatchTry\\src\\main\\resources\\com\\example\\dmibatchtry\\WeatherDataTableData.txt"));
            sc.useDelimiter("\t\n");   //sets the delimiter pattern
            counter = 0;
            while (sc.hasNext())  //returns a boolean value
            {
                for (int i = 0; i < 12; i++) {
                    stmt.setInt(1, Integer.parseInt(sc.next()));
                    stmt.setTimestamp(2, Timestamp.valueOf(sc.next()));
                    stmt.setFloat(3, Float.parseFloat(sc.next()));
                    stmt.setFloat(4, Float.parseFloat(sc.next()));
                    stmt.setFloat(5, Float.parseFloat(sc.next()));
                    stmt.setFloat(6, Float.parseFloat(sc.next()));
                    stmt.setFloat(7, Float.parseFloat(sc.next()));
                    stmt.setFloat(8, Float.parseFloat(sc.next()));
                    stmt.setFloat(9, Float.parseFloat(sc.next()));
                    stmt.setFloat(10, Float.parseFloat(sc.next()));
                    stmt.setInt(11, Integer.parseInt(sc.next()));
                    stmt.setInt(12, Integer.parseInt(sc.next()));
                    counter++;
                    System.out.println(counter);
                    System.out.println(sc);
                    //System.out.println("test1" + sc.next());
                    stmt.addBatch();
                    if (i == 12) {
                        System.out.println();

                    }
                    sc.close();
                    stmt.executeBatch();
                    conn.commit();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

