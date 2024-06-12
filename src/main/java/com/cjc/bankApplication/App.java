package com.cjc.bankApplication;

import java.util.Scanner;

import com.cjc.bankApplication.service.RBI;
import com.cjc.bankApplication.serviceImpl.ICICIBank;

public class App {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RBI rbi = new ICICIBank();

		while (true) {
			System.out.println("**************WELCOME TO BANK APPLICATION*************");
			System.out.println("Enter 1 For Create Account");
			System.out.println("Enter 2 For View Account Details");
			System.out.println("Enter 3 For Deposite Money ");
			System.out.println("Enter 4 For WithDrawl Money");
			System.out.println("Enter 5 For View Balance");
			System.out.println("Enter 6 For Update Data");
			System.out.println("Enter 7 For Exit");
			System.out.println("*****************************************************");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				rbi.createAccount();
				break;

			case 2:
				rbi.viewDetails();
				break;

			case 3:
				rbi.depositeMoney();
				break;

			case 4:
				rbi.withdrawlMoney();
				break;

			case 5:
				rbi.viewBalance();
				break;

			case 6:
				rbi.updateData();
				break;

			case 7:
				System.out.println("Thank You For Banking With us....!");
				System.exit(0);
				break;
			}
		}

	}
}
