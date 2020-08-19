package com.company;

import java.util.Arrays;

public class Budget implements RecordMethods {

    private ExpensesRecords[] expenses;
    private IncomeRecords[] income;
    private double balance;
    private double bankBalance;

    public Budget() {
        this.expenses = new ExpensesRecords[5];
        this.income = new IncomeRecords[5];
        this.balance = 0;
    }

    @Override
    public void addIncomeRecord(IncomeRecords record) {
        for (int index = 0; index < income.length; index++) {
            if (income[index] == null) {
                income[index] = record;
                break;
            }
        }
    }

    @Override
    public void addExpensesRecord(ExpensesRecords record) {
        for (int index = 0; index < expenses.length; index++) {
            if (expenses[index] == null) {
                expenses[index] = record;
                System.out.println("Added");
                break;
            }
        }
    }

    @Override
    public void returnIncomeRecord(int index) {
        System.out.println(income[index]);
    }

    @Override
    public void returnExpensesRecord(int index) {
        System.out.println(expenses[index]);
    }

    public ExpensesRecords[] getExpenses() {
        return expenses;
    }

    public IncomeRecords[] getIncome() {
        return income;
    }

    void adjustBalance() {
        // Count Income and Add to Balance;
        this.balance = 0;
        for (IncomeRecords incomeRecords : income) {
            if (incomeRecords != null) {
                double addSum = incomeRecords.getAmount();
                this.balance += addSum;
            }
        }
        //Count Expenses and Add to Balance;
        for (ExpensesRecords expens : expenses) {
            if (expens != null) {
                double subtractSum = expens.getAmount();
                this.balance -= subtractSum;
            }
        }
        System.out.println("Budget is: " + this.balance);
    }

    void checkBankBalance () {
        this.bankBalance = 0;
        // Income
        for (int index = 0; index < income.length; index++) {
            if (income[index] != null && income[index].isBankTransaction()) {
                double newSum = income[index].getAmount();
                this.bankBalance += newSum;
            }
        }
        // Expenses
        for (int index = 0; index < expenses.length; index++) {
            if (expenses[index] != null && expenses[index].isTransactionType()) {
                double newSum = expenses[index].getAmount();
                this.bankBalance -= newSum;
            }
        }
        System.out.println("Bank Budget is: " + this.bankBalance);
    }

    void returnOnlyIncomeAmount () {
        int subNum = 0;
        double [] amountArray = new double[income.length];
        for (int index = 0; index < income.length; index++) {
            if (income[index] != null) {
                amountArray[index] = income[index].getAmount();
            }
            else {
                subNum++;
                amountArray = new double[income.length - subNum]; // Atnaujina Array. Dėl to nelieka reikšmių.
            }
        }
        if (amountArray.length == 0) {
            System.out.println("Not a Single Income Payment Has Been Made!");
        } else {
            System.out.println(Arrays.toString(amountArray));
        }
    }
}

