package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Transactions> transactionHistory = getTransactionFromFile();

    //Main menu and choices
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

        System.out.print("State what this deposit is for: ");
        String description = scanner.nextLine();

        System.out.print("Please state the place where this deposit is coming from: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter deposit amount: ");
        Double amount = scanner.nextDouble();

        //Calling the method to save info to file
        saveTransactionFromUser(description, vendor, amount);
    }
    private static void makePayment(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("State what this payment is for: ");
        String description = scanner.nextLine();

        System.out.print("Please state where this payment is going: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter your payment amount: ");
        //This will make sure that the money will show it's negative (aka losing money)
        Double amount = scanner.nextDouble() * -1;

        //Calling the method to save info to file
        saveTransactionFromUser(description, vendor, amount);

    }

    //Methods for reading and writing info to transactions.csv
    private static void saveTransactionFromUser(String description, String vendor, Double amount){
        try {
            FileWriter fileWriter = new FileWriter("transactions.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Transactions t = new Transactions(LocalDate.now(), LocalTime.now(), description, vendor, amount);
            transactionHistory.add(t);

            bufferedWriter.newLine();

            bufferedWriter.write(t.getDate() + "|"
                    + t.getTime() + "|"
                    + t.getDescription() + "|"
                    + t.getVendor() + "|"
                    + t.getAmount());
            bufferedWriter.close();

        } catch (Exception e){
            System.out.println("There was a problem, try again!");
        }
    }
    private static ArrayList<Transactions> getTransactionFromFile () {
        ArrayList<Transactions> transactionHistory = new ArrayList<Transactions>();
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
                transactionHistory.add(t);
            }//todo Don't forget about "t" variable when you do ledger

        } catch (Exception e) {
            System.out.println("There was a problem, try again!");
        }

        return transactionHistory;
    }

    //Ledger menu and choices
    public static void goToLedger() {
        String ledgerMenu = "--------------------------------------------\n" +
                "⋆｡ﾟ☁｡⋆☾｡ Ledger Screen ⋆｡ﾟ☁｡⋆｡☾\n" +
                "A) All Entries\n" +
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

    private static void viewAllLedger(){
        System.out.println("Showing all transactions:");

        for(Transactions t : transactionHistory){
            System.out.println(t);
        }

        System.out.println();
    }
    private static void viewDeposits (){
        System.out.println("Showing all deposits:");
        for (Transactions t : transactionHistory) {
            if (t.getAmount() >= 0) {
                System.out.println(t);
            }
        }
    }
    private static void viewPayments (){
        System.out.println("Showing all payments:");
        for (Transactions t : transactionHistory){
            if (t.getAmount() <= 0){
                System.out.println(t);
            }
        }
    }

    //Reports menu and choices
    public static void viewReports(){
        String ledgerMenu = "--------------------------------------------\n" +
                "⋆｡ﾟ☁｡⋆☾｡ Reports Screen ⋆｡ﾟ☁｡⋆｡☾\n" +
                "1) Month To Date \n" +
                "2) Previous Month \n" +
                "3) Year To Date \n" +
                "4) Previous Year \n" +
                "5) Search by Vendor \n" +
                "0) Back - go back to Ledger \n" +
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
                case 5:
                    searchByVendor();//type in vendor
                    break;
                case 0: goToLedger();
                    return;
                default:
                    System.out.println("INVALID COMMAND!! Please select a valid option.");
                    break;
            }


        }


    }

    private static void viewMonthToDate(){
        System.out.println(" Month to date Transaction");
        LocalDate today = LocalDate.now();
        for ( Transactions t: transactionHistory) {
            if (t.getDate().getYear() == today.getYear() &&  // Check if the transaction happened in the current year
                    t.getDate().getMonth() == today.getMonth()) {
                System.out.println(t);    // Print the transaction details if it matches the current year
            }
        }
    }      //todo
    private static void viewPreviousMonth(){
        System.out.println(" Previous Month Transaction");
        LocalDate today =LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        for ( Transactions t : transactionHistory){
            if (t.getDate().getYear() == today.getYear() &&  // Check if the transaction happened in the current year
                    t.getDate().getMonth() == today.getMonth()) {
                System.out.println(t);    // Print the transaction details if it matches the current year
            }
        }
    }

    private static void viewYearToDate(){
        System.out.println("Year to date transactions");
        int currentYear = LocalDate.now().getYear();
        for (Transactions transactions : transactionHistory){
            if(transactions.getDate().getYear()== currentYear) {
                System.out.println(transactions);
            }
        }
    }
    private static void viewPreviousYear(){
        System.out.println("previous Year");
        int lastYear = LocalDate.now().getYear() -1;
        for (Transactions transactions : transactionHistory){
            if(transactions.getDate().getYear()== lastYear) {
                System.out.println(transactions);
            }
        }

    }
    private static void searchByVendor(){
        String vendor = ConsoleHelper.promptForString("Please state a vendor to search:");
        System.out.println("Transactions for vendor: " + vendor);
        boolean isfind = false;
        for (Transactions t: transactionHistory)
        if(t.getVendor().equalsIgnoreCase(vendor)) {
            System.out.println(t);
            isfind = true;

           } if(!isfind){
            System.out.println("Vendor Not Available");
        }
    }
}
