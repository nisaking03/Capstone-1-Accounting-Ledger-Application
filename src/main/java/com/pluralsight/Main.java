package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Transactions> transaction = getTransactionFromFile();


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
        System.out.println("Enter deposit amount: \n");
        System.out.println("State what this transaction is for? \n");
        System.out.println("Please state the place where this deposit is coming from: \n");//Make it to where time uses time now for info
    }

    private static void makePayment() {
        System.out.println("Enter your payment amount: \n");
        System.out.println("State what this transaction is for: \n");
        System.out.println("Please state where this payment is going: \n");
    }

    public static void goToLedger() {
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

    private static void viewAllLedger(){

    }
    private static void viewDeposits (){

    }
    private static void viewPayments (){

    }
    private static void viewReports(){

    }

}

        //    public static ArrayList<Transactions> getTransactionFromCode(){
//        ArrayList<Transactions> blank = new ArrayList<>();
//    } //unsure how to do system print

            /*Will contain:todo D) Add Deposit - prompt user for the deposit
                    information and save it to the csv file (" transactions.csv ")*/
    /*Will contain: todo P) Make Payment (Debit) - prompt user for the debit
                     information and save it to the csv file (" transactions.csv ")*/
        /*Will contain: todo L) Ledger - display the ledger screen*/

        /* todo This will be (" transactions.csv ") format */




        //todo New screen ("Ledger") coming from Home Screen - All entries should show the newest entries first
        //(May be a Class/Method) //Will need Scanner

        /*Will contain: todo A) All - Display all entries*/
        /*Will contain: todo D) Deposits - Display only the entries that are deposits into the account*/
        /*Will contain: todo P) Payments - Display only the negative entries (or payments)*/
    /*Will contain: todo R) Reports - A new screen that allows the user to run
                     pre-defined reports or to run a custom search*/



        //todo ("Reports") coming from Ledger Screen
        //(May be a Class/Method) //Will need Scanner

        /*Will contain: todo 1) Month To Date*/
        /*Will contain: todo 2) Previous Month*/
        /*Will contain: todo 3) Year To Date*/
        /*Will contain: todo 4) Previous Year*/
    /*Will contain: todo 5) Search by Vendor prompt the user for the
                     vendor name and display all entries for that vendor*/
        /*Will contain: todo 0) Back - go back to the Ledger page*/
        /*Will contain: todo H) Home - go back to the home page*/
