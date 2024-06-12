package com.cjc.bankApplication.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.bankApplication.config.HibernateConfig;
import com.cjc.bankApplication.model.Account;
import com.cjc.bankApplication.service.RBI;

public class ICICIBank implements RBI {

	Scanner sc = new Scanner(System.in);

	public void createAccount() {

		Account ac = new Account();

		System.out.println("Enter Account Holder Name");
		ac.setAcName(sc.next() + sc.nextLine());
		System.out.println("Enter Account Holder Address");
		ac.setAddress(sc.next() + sc.nextLine());
		System.out.println("Enter Account Holder Mobile No");
		ac.setMobileNo(sc.nextLong());
		System.out.println("Enter Account Holder Aadhar No");
		ac.setAdharNo(sc.nextLong());
		System.out.println("Enter Account Holder Pan No");
		ac.setPanNo(sc.next() + sc.nextLine());
		System.out.println("Enter Account Holder Gender");
		ac.setGender(sc.next());
		System.out.println("Enter Account Holder Balance");
		ac.setBalance(sc.nextDouble());

		// logic to save Data in DB
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ac);
		tx.commit();
		System.out.println("Account Created SuccessFully...!");

	}

	public void viewDetails() {

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		System.out.println("Enter Account Number To get Data");
		int acNo = sc.nextInt();

		Account account = session.get(Account.class, acNo);

		System.out.println("*****Acccount Holder Details*****");

		System.out.println(account);

	}

	public void depositeMoney() {

		System.out.println("Enter Account Number To Deposite Money");
		int acNo = sc.nextInt();

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Account ac = session.get(Account.class, acNo);

		if (ac != null) {

			double balance = ac.getBalance();
			System.out.println("Enter Amount To Deposite Money");
			double amt = sc.nextDouble();
			double newbal = balance + amt;

			ac.setBalance(newbal);

			session.update(ac);
			tx.commit();
			System.out.println("Amount Deposited SuccessFully...!" + amt + " rs.");
		} else {
			System.out.println("Invalid Account Number...!");
		}

	}

	public void withdrawlMoney() {

		System.out.println("Enter Account Number To WtihDrawl Money");
		int acNo = sc.nextInt();

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Account ac = session.get(Account.class, acNo);

		if (ac != null) {

			double balance = ac.getBalance();

			System.out.println("Enter Amount To WithDrawl Money");
			double amt = sc.nextDouble();

			if (amt <= balance) {
				if (amt >= 100) {
					double newbal = balance - amt;
					ac.setBalance(newbal);
					session.update(ac);
					tx.commit();
					System.out.println("Amount WithDrawl SuccessFully.." + amt + " rs.");
				} else {
					System.out.println("WithDrawl Amount Should be Greater Than 100");
				}

			} else {
				System.out.println("Insufficiant Funds....!");
			}

		} else {
			System.out.println("Invalid Account Number...!");
		}

	}

	public void viewBalance() {

		System.out.println("Enter Account Number To View Balance");
		int acNo = sc.nextInt();

		String hql = "select balance from Account where acNo=?";

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		Query query = session.createQuery(hql);

		query.setParameter(0, acNo);

		double balance = (Double) query.getSingleResult();

		System.out.println("Your Current Account Balance is :" + balance + " rs.");

	}

	public void updateData() {
		System.out.println("Enter Account Number To Update Data");
		int acNo = sc.nextInt();

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();
		Transaction tx = null;

		Account account = session.get(Account.class, acNo);

		if (account != null) {

			boolean flag = true;

			while (flag) {
				System.out.println("Enter 1 For Update Name");
				System.out.println("Enter 2 for Update Mobile No");
				System.out.println("Enter 3 For Update Address");
				System.out.println("Enter 4 For Exit");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					tx = session.beginTransaction();
					System.out.println("Enter Updated Name Here");
					account.setAcName(sc.next() + sc.nextLine());
					session.update(account);
					tx.commit();
					System.out.println("Name Updated SuccessFully...!");
					break;
				case 2:
					tx = session.beginTransaction();
					System.out.println("Enter Updated MobileNo Here");
					account.setMobileNo(sc.nextLong());
					session.update(account);
					tx.commit();
					System.out.println("Name Updated SuccessFully...!");
					break;

				case 3:
					tx = session.beginTransaction();
					System.out.println("Enter Updated Address Here");
					account.setAddress(sc.next() + sc.nextLine());
					session.update(account);
					tx.commit();
					System.out.println("Name Updated SuccessFully...!");
					break;

				case 4:
					flag = false;
					break;

				default:
					System.out.println("******Wrong Choice******");
					break;
				}
			}
		} else {
			System.out.println("Invalid Accoun Number...!");
		}

	}

}
