package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    //Final to make the transaction object immutable
    private final String type;
    private final double amount;
    private final Date timestamp;
    private final double balanceAfterTransaction;


    public Transaction(String type , double amount , double balanceAfterTransaction){
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    //Custom toString
    //Date format
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Formatted String
        return String.format("| %-20s | %-10s | %10.2f | %15.2f |",
                sdf.format(timestamp), type, amount, balanceAfterTransaction);
    }
}
