package com.pluralsight;

import java.util.Scanner;

public class ConsoleHelper {

private static Scanner scanner = new Scanner(System.in);

//    public static String promptForString(String prompt) {
//        System.out.println(prompt + ": ");
//        return scanner.nextLine();
//    }

    public static int promptForInt(String prompt) {
        System.out.print(prompt + ": ");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

//    public static float promptForFloat(String prompt) {
//        System.out.println(prompt + ": ");
//        float result = scanner.nextFloat();
//        scanner.nextLine();
//        return result;
//    }

    public static char promptForChar(String prompt) {
        System.out.print(prompt + ": ");
        char result = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();
        return result;
    }

//    public static double promptForDouble(String prompt) {
//        System.out.println(prompt + ": ");
//        double result = scanner.nextDouble();
//        scanner.nextLine();
//        return result;
//    }

}
