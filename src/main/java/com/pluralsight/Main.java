package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Transactions> transaction = getTransactionFromFile();

    public static void main(String[]args){
        char mainMenuOptions;
        String mainMenu = "--------------------------------------------\n" +
            "Home Screen\n" +
            "D) Add Deposit\n" +
            "P) Make Payment\n" +
            "L) Ledger\n" +
            "X) Exit\n" +
            "Select where you would like to be directed.\n" +
            "--------------------------------------------";

        while(true){
            switch (mainMenuOptions) {
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
        System.out.println("");
    }
    private static void makePayment() {
        System.out.println("");
    }
    private static void goToLedger() {
        System.out.println("");
    }


//    public static ArrayList<Transactions> getTransactionFromCode(){
//        ArrayList<Transactions> blank = new ArrayList<>();
//    } //unsure how to do system print

    public static ArrayList<Transactions> getTransactionFromFile(){
        ArrayList<Transactions> transaction = new ArrayList<Transactions>();
        try{
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String lineFromString;

            while((lineFromString = bufferedReader.readLine()) !=null){
                String[] part = lineFromString.split("\\|");
                String date = part[0];
                String time part[1];
                String description = part[2];
                String vendor = part[3];
                double amount = Double.parseDouble(part[4]);

                Transactions t = new Transactions(date, time, description, vendor, amount);
                transaction.add(t);
            }//todo Don't forget about "t" variable when you do ledger

        }
        catch (Exception e){
            System.out.println("There was a problem, try again!");
        }

        return transaction;

    }


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
}
