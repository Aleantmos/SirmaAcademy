package _3_BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        List<Account> accounts = new ArrayList<>();

        while (!line.equals("End")){
            String[] tokens = line.split(" ");
            String command = tokens[0];


            if (command.equals("Create")) {
                Account account = new Account();
                accounts.add(account);
                System.out.printf("Account ID%d created%n", account.getId());

            } else if (command.equals("Deposit")) {
                int currId = Integer.parseInt(tokens[1]);
                double amount = Double.parseDouble(tokens[2]);

                Account account = getAccount(accounts, currId);

                if (account == null) {
                    accountDoesNotExist(currId);
                } else {
                    account.deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, currId);
                }

            } else if (command.equals("GetInterest")) {
                int currId = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                Account account = getAccount(accounts, currId);

                if (account == null) {
                    accountDoesNotExist(currId);
                } else {
                    System.out.printf("%.2f%n", account.getInterest(years));
                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]) / 100;
                Account.setInterest(interest);
            }
            line = scan.nextLine();
        }
    }

    private static Account getAccount(List<Account> accounts, int currId) {
        return accounts.stream().filter(a -> a.getId() == currId)
                .findFirst()
                .orElse(null);
    }

    private static void accountDoesNotExist(int currId) {
        System.out.println("Account not found for ID:" + currId);
    }
}
