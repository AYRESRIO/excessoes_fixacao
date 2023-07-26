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
		String error = account.validateWithdraw(amount);
		if (error != null) {
			System.out.println(error);
		} else {
			account.withdraw(amount);
			System.out.println(account.toString());
		}

		sc.close();

	}

}
