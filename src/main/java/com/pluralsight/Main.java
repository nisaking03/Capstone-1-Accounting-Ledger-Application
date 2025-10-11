package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String mainMenu = "--------------------------------------------\n" +
                "⋆｡ﾟ☁｡⋆☾｡ Home Screen ⋆｡ﾟ☁｡⋆｡☾\n" +
                "D) Add Deposit\n" +
                "P) Make Payment\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                "Select where you would like to be directed.\n" +
                "--------------------------------------------\n";

        while (true) {
            System.out.print(mainMenu);
            char command;

            command = ConsoleHelper.promptForChar("Enter your command");

            switch (command) {
                case 'D':
                    addDeposit();//go to deposit
                    break;
                case 'P':
                    makePayment();//go make payment
                    break;
                case 'L':
                    goToLedger();//go to ledger screen
                    break;
                case 'X': //exit
                    return;
                default:
                    System.out.println("INVALID COMMAND!! Please select a valid option.");
                    break;

            }

        }

    }

    private static void addDeposit() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter deposit amount: \n");
        scanner.next();

        System.out.println("State what this transaction is for? \n");
        scanner.next();

        System.out.println("Please state the place where this deposit is coming from: \n");
        scanner.next();
    }       //todo Make it to where time uses time now for info
                                                 //todo Needs to send data back to (transaction.csv)
    private static void makePayment() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your payment amount: \n");
        scanner.next();

        System.out.println("State what this transaction is for: \n");
        scanner.next();

        System.out.println("Please state where this payment is going: \n");
        scanner.next();
    }      //todo Make it to where time uses time now for info
                                                 //todo Needs to send data back to (transaction.csv)

    private static void goToLedger() {
        String ledgerMenu = "--------------------------------------------\n" +
                "⋆｡ﾟ☁｡⋆☾｡ Ledger Screen ⋆｡ﾟ☁｡⋆｡☾\n" +
                "A) All \n" +
                "D) Deposits \n" +
                "P) Payments \n" +
                "R) Reports \n" +
                "H) Back to Home \n" +
                "--------------------------------------------\n";
        while (true) {
            System.out.print(ledgerMenu);
            char command;

            command = ConsoleHelper.promptForChar("Enter your command");

            switch (command) {
                case 'A':
                    viewAllLedger();//see all together
                    break;
                case 'D':
                    viewDeposits();//go to deposit
                    break;
                case 'P':
                    viewPayments();//go to payments
                    break;
                case 'R':
                    viewReports();//go to reports
                    break;
                case 'H':
                    return;
                default:
                    System.out.println("INVALID COMMAND!! Please select a valid option.");
                    break;
            }
        }
    }

    private static ArrayList<Transactions> getTransactionFromFile () {
            ArrayList<Transactions> transaction = new ArrayList<Transactions>();
            try {
                FileReader fileReader = new FileReader("transactions.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String lineFromString;

                while ((lineFromString = bufferedReader.readLine()) != null) {
                    String[] part = lineFromString.split("\\|");
                    LocalDate date = LocalDate.parse(part[0]);
                    LocalTime time = LocalTime.parse(part[1]);
                    String description = part[2];
                    String vendor = part[3];
                    double amount = Double.parseDouble(part[4]);

                    Transactions t = new Transactions(date, time, description, vendor, amount);
                    transaction.add(t);
                }//todo Don't forget about "t" variable when you do ledger

            } catch (Exception e) {
                System.out.println("There was a problem, try again!");
        }

            return transaction;
    }
    public static ArrayList<Transactions> transaction = getTransactionFromFile();

    private static void viewAllLedger(){
    }        //todo Will show all transactions
    private static void viewDeposits (){
    }        //todo Will only show money put into account (positive numbers)
    private static void viewPayments (){
    }        //todo Will only show money taken out (negative numbers)


    private static void viewReports(){
        String ledgerMenu = "--------------------------------------------\n" +
                "⋆｡ﾟ☁｡⋆☾｡ Reports Screen ⋆｡ﾟ☁｡⋆｡☾\n" +
                "1) Month To Date \n" +
                "2) Previous Month \n" +
                "3) Year To Date \n" +
                "4) Previous Year \n" +
                "5) Back - go back to Ledger \n" +
                "--------------------------------------------\n";
        while (true) {
            System.out.print(ledgerMenu);
            int command;

            command = ConsoleHelper.promptForInt("Enter your command");

            switch (command) {
                case 1:
                    viewMonthToDate();//see all together
                    break;
                case 2:
                    viewPreviousMonth();//go to deposit
                    break;
                case 3:
                    viewYearToDate();//go to payments
                    break;
                case 4:
                    viewPreviousYear();//go to reports
                    break;
                case 5: goToLedger();
                    return;
                default:
                    System.out.println("INVALID COMMAND!! Please select a valid option.");
                    break;
            }


        }


    }

    private static void viewMonthToDate(){

    }      //todo 
    private static void viewPreviousMonth(){

    }    //todo
    private static void viewYearToDate(){
    }       //todo
    private static void viewPreviousYear(){

    }     //todo
}
