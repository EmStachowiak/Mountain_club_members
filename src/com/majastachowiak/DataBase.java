package com.majastachowiak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBase {
    public static Connection getConnection() throws Exception {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            if (connection == null){
                System.out.println("Not connected");
            } else {
                System.out.println("Connected");
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createTable() throws  Exception {
        try {
            Connection connection = getConnection();

            PreparedStatement create = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS Mountain_Club_Members " +
                            "(id int NOT NULL AUTO_INCREMENT, name varchar(20), surname varchar(50), age int, advancement int(1), highest_peak int, phoneNumber int, PRIMARY KEY(id))");
            create.executeUpdate();
            //System.out.println("The table was successfully created");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void post() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new member: ");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the new member: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the age of the new member: ");
        int age = scanner.nextInt();
        System.out.println("Enter the advancement of the new member (scale from 0 to 10): ");
        int advancement = scanner.nextInt();
        System.out.println("Enter the height of the highest peak climbed by the new member: ");
        int highest_peak = scanner.nextInt();
        System.out.println("Enter the phone number of the new member: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();

        try {
            Connection connection = getConnection();
            PreparedStatement posted = connection.prepareStatement
                    ("INSERT INTO Mountain_Club_Members" +
                            "(name, surname, age, advancement, highest_peak, phoneNumber) " +
                            "VALUES ('" + name + "', '" +  surname + "', '" +   age + "', '" + advancement + "', '" + highest_peak + "', " + phoneNumber + ")");

            System.out.println("\nYou just added new member: " +
                    "\nName: " + name +
                    "\nSurname: " + surname +
                    "\nAge: " + age +
                    "\nAdvancement: " + advancement +
                    "\nHighest peak: " + highest_peak +
                    "\nPhone number: " + phoneNumber
            );

            posted.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
