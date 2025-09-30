package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Account account = null; // The account is null initially

        System.out.println("Welcome to the Bank Simulation!");
        System.out.println("Create an account.");


        while (account == null) {
            try {
                System.out.print("Enter your full name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your account number: ");
                String accNumber = scanner.nextLine();
                System.out.print("Enter your initial deposit amount: ");
                double initialDeposit = scanner.nextDouble();
                scanner.nextLine(); // Consume the leftover newline character

                if (initialDeposit < 0) {
                    System.out.println("Initial deposit cannot be negative. Please try again.");
                    continue;
                }

                account = new Account(accNumber, name, initialDeposit);
                System.out.println("Account created successfully!");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        boolean exit = false;
        while (!exit) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        handleDeposit(scanner, account);
                        break;
                    case 2:
                        handleWithdrawal(scanner, account);
                        break;
                    case 3:
                        account.printStatement();
                        break;
                    case 4:
                        System.out.println("Exit........!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Print Account Statement");
        System.out.println("4. Exit");
        System.out.println("-----------------");
    }

    private static void handleDeposit(Scanner scanner, Account account) {
        try {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void handleWithdrawal(Scanner scanner, Account account) {
        try {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.withdraw(amount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.nextLine(); // Clear the bad input
        }
    }
}