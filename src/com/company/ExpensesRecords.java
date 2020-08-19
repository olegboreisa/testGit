package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ExpensesRecords {

    private double amount;
    private LocalDate dateTime;
    private boolean transactionType;
    private String info;
    private static int category;

    public ExpensesRecords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Expenses Amount: ");
        this.amount = scanner.nextDouble();

        this.transactionType = transactionType();

        System.out.print("Enter Transaction Information: ");
        this.info = scanner.next();

        category++;

        this.dateTime = dateTime.now();
        System.out.println("[Record Created and Added to the Expenses Array!]");
    }

    boolean transactionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Transaction Type: Cash or Bank: ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("Cash")) {
            return false;
        } else if (input.equalsIgnoreCase("Bank")) {
            return true;
        } else {
            System.out.println("Incorrect input");
            transactionType();
        }
        return true; //?
    }

    @Override
    public String toString() {
        return String.format("[%s] Transaction Sum: %.2f$\nInformation: [%s]", dateTime.toString(), amount, info);
    }

    public double getAmount() {
        return amount;
    }

    public boolean isTransactionType() {
        return transactionType;
    }
}
