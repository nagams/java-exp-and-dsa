package com.dipendit.card;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardBank {

    private static Map<String, Account> bank = new HashMap<>();
    private static Map<String, Account2> bank2 = new HashMap<>();

    public static void main(String[] args) {
        bank.put("account1", new Account("account1", 2500));
        bank.put("account2", new Account("account2", 200));
        bank.put("account3", new Account("account3", 2300));
        bank.put("account6", new Account("account6", 2700));
        bank.put("account5", new Account("account5", 3000));
        bank.put("account4", new Account("account4", 2700));

        System.out.println(bank.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .toList());


        bank2.put("account1", new Account2("account1", 2500));
        bank2.put("account2", new Account2("account2", 200));
        bank2.put("account3", new Account2("account3", 2300));
        bank2.put("account6", new Account2("account6", 2700));
        bank2.put("account4", new Account2("account4", 2700));
        bank2.put("account5", new Account2("account5", 3000));

        System.out.println(
                bank2.values().stream()
                              .sorted(Comparator.comparing(Account2::getActiveAmount)
                                                .reversed()
                                                .thenComparing(Account2::getAccountId))
                              .toList());

        String[] result = bank2.values().stream()
                                        .sorted(Comparator.comparing(Account2::getActiveAmount).reversed()
                                                          .thenComparing(Account2::getAccountId))
                                        .map(Account2::toString)
                                        .toArray(String[]::new);
        System.out.println(Arrays.toString(result));
    }
}

class Account2 {
    String accountId;
    double balance;
    double activeAmount;

    public Account2(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.activeAmount = balance;
    }

    double deposit(double amount) {
        balance += amount;
        activeAmount += amount;
        return balance;
    }

    double withdraw(double amount) {
        balance -= amount;
        activeAmount += amount;
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getActiveAmount() {
        return activeAmount;
    }

    @Override
    public String toString() {
        return accountId + " : " + activeAmount;
    }
}

class Account implements Comparable<Account> {
    String accountId;
    double balance;
    double activeAmount;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.activeAmount = balance;
    }

    double deposit(double amount) {
        balance += amount;
        activeAmount += amount;
        return balance;
    }

    double withdraw(double amount) {
        balance -= amount;
        activeAmount += amount;
        return balance;
    }

    @Override
    public String toString() {
        return accountId + " : " + activeAmount;
    }

    @Override
    public int compareTo(Account o) {
        int result = Double.compare(o.activeAmount, this.activeAmount);
        if (result == 0) {
            result = this.accountId.compareTo(o.accountId);
        }
        return result;
    }
}
