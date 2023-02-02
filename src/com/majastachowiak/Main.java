package com.majastachowiak;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        System.out.println("MOUNTAIN CLUB MEMBERS\n");


        while (shouldContinue == true) {

            System.out.println("What you want to do: " +
                    "\n1. Create new table" +
                    "\n2. Add new member" +
                    "\n3. See all club members" +
                    "\n4. Delete table" +
                    "\n5. EXIT");
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    DataBase.createTable();
                    break;
                 case 2:
                    DataBase.addMember();
                    break;
                 case 3:
                    DataBase.showEverything();
                    break;
                case 4:
                    DataBase.deleteTable();
                    break;
                 case 5:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Wrong choice, try again");
                    break;
            }

        }
    }
}
