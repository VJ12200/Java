package org.example;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private String accountNo;
    private String holder;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNo, String holder, double deposit){
        this.accountNo = accountNo;
        this.holder = holder;
        balance = deposit;
        //Storing transaction objects inside an Array List to avoid NPE
        this.transactionHistory = new ArrayList<>();
        addTransaction("INTITIAL DEPOSIT", deposit);
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Deposit amount can't be 0!");
            return;
        }
        this.balance += amount;
        addTransaction("DEPOSIT", amount);
        System.out.printf("Deposited amount $%.1f. New balance is $%.1f.%n", amount, this.balance);
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return;
        }
        this.balance -= amount;
        addTransaction("WITHDRAWAL", amount);
        System.out.printf("Withdrawl Amount $%.1f. New balance is $%.1f.%n", amount, this.balance);
    }

    private void addTransaction(String type, double amount) {
        Transaction newTransaction = new Transaction(type, amount, this.balance);
        this.transactionHistory.add(newTransaction);
    }

    public void printStatement() {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Account Statement for " + this.holder + " (" + this.accountNo + ")");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("| %-20s | %-10s | %10s | %15s |\n", "Timestamp", "Type", "Amount", "Balance");
        System.out.println("-------------------------------------------------------------------");
        for (Transaction tx : this.transactionHistory) {
            System.out.println(tx);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("Current Balance: $%.2f\n", this.balance);
        System.out.println("-------------------------------------------------------------------");
    }
}
