package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Budget budget = new Budget();
        createMenu();
        boolean exit = false;
        while (!exit) {
            int selection = scanner.nextInt();
            switch (selection) {
                case (0):
                    exit = true;
                    break;
                case (1):
                    budget.addIncomeRecord(new IncomeRecords());
                    createMenu();
                    break;
                case (2):
                    budget.addExpensesRecord(new ExpensesRecords());
                    createMenu();
                    break;
                case (3):
                    System.out.print("Add index (category) to get an Income Record: ");
                    int inputI = scanner.nextInt() - 1; // 1 as a 0 in Array;
                    budget.returnIncomeRecord(inputI);
                    createMenu();
                    break;
                case (4):
                    System.out.print("Add index (category) to get an Expenses Record: ");
                    int inputE = scanner.nextInt() - 1; // 1 as a 0 in Array;
                    budget.returnIncomeRecord(inputE);
                    createMenu();
                    break;
                case (5):
                    System.out.println(Arrays.toString(budget.getIncome()));
                    createMenu();
                    break;
                case (6):
                    System.out.println(Arrays.toString(budget.getExpenses()));
                    createMenu();
                    break;
                case (7):
                    budget.adjustBalance();
                    createMenu();
                    break;
                case (8):
                    budget.returnOnlyIncomeAmount();
                    createMenu();
                    break;
                case (9):
                    budget.checkBankBalance();
                    createMenu();
                    break;
                default:
                    System.out.println("Incorrect input");
                    createMenu();
            }
        }
        scanner.close();
    }

    static void createMenu () {
        System.out.print("" +
                "_________________________\n" +
                "Select Following:\n" +
                "0 - Exit\n" +
                "1 - Create Income Record\n" +
                "2 - Create Expenses Record\n" +
                "3 - Get Specific Income Record\n" +
                "4 - Get Specific Expenses Record\n" +
                "5 - Check Full Income Array\n" +
                "6 - Check Full Expenses Array\n" +
                "7 - Check Balance\n" +
                "8 - Get Income Amount Records Only\n" +
                "9 - Bank Balance\n" +
                "Enter: ");
    }
}

