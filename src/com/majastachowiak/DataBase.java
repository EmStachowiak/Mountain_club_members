package com.majastachowiak;

import java.sql.*;
import java.util.Scanner;

public class DataBase {
    public static Connection getConnection() throws Exception {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
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

    public static void deleteTable () throws  Exception {
        try {
            Connection connection = getConnection();
            PreparedStatement delete = connection.prepareStatement("DROP TABLE Mountain_Club_Members ");
            delete.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMember() throws Exception {

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

    public static void showEverything() throws  Exception {

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Mountain_Club_Members");
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                System.out.println("Member nr: " + (result.getInt("id")));
                System.out.println("Name: " + (result.getString("name")));
                System.out.println("Surname: " + (result.getString("surname")));
                System.out.println("Age: " + (result.getInt("age")));
                System.out.println("Advancement: " + (result.getInt("advancement")));
                System.out.println("Highest peak: " + (result.getInt("highest_peak")));
                System.out.println("Phone number: " + (result.getInt("phoneNumber")));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
