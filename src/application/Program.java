package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.print("Number:");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();

		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		if (amount > account.getBalance()) {
			System.out.println("You don't have this amount.Verify your balance!");
			amount = 0.00;
		} else {
			while (amount > account.getWithdrawLimit()) {
				System.out.println("YOUR WITHDRAW LIMIT IS: R$ " + String.format("%.2f", account.getWithdrawLimit()));
				System.out.print("Do you want try again?(y/n)");
				char option = sc.next().charAt(0);
				if (option == 'y') {
					System.out.print("Enter amount for withdraw: ");
					amount = sc.nextDouble();
				} else {
					amount = 0.00;
				}

			}

		}
		account.withdraw(amount);

		System.out.println(account.toString());

		sc.close();

	}

}
