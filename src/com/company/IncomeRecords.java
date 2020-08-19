package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class IncomeRecords {

    private double amount;
    private LocalDate date;
    private boolean isBankTransaction;
    private String info;
    private static int category;

    public IncomeRecords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Income Amount: ");
        this.amount = scanner.nextDouble();

        this.isBankTransaction = transactionType();

        System.out.print("Enter Transaction Information: ");
        this.info = scanner.next();

        category++;

        this.date = LocalDate.now();
        System.out.println("[Record Created and Added to the Income Array!]");
    }

    boolean transactionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bank Transaction?: Yes or No: ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("no")) {
            return false;
        } else if (input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Incorrect input");
            transactionType();
        }
        return true; //
    }

    @Override
    public String toString() {
        return String.format("[%s] Transaction Sum: %.2f$\nInformation: [%s]", date.toString(), amount, info);
    }

    public double getAmount() {
        return amount;
    }

    public boolean isBankTransaction() {
        return isBankTransaction;
    }
}
