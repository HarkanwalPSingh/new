package com.cg.banking.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {

	public static void main(String[] args)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {

		ApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
		BankingServices bankingServices = (BankingServices) context.getBean("bankingServices");

		try {
			bankingServices.openAccount("Saving", 9000);
			System.out.println(bankingServices.getAccountDetails(123123123));
			bankingServices.depositAmount(123123123, 5000);
			bankingServices.withdrawAmount(123123123, 10000, 1234);
			System.out.println(bankingServices.getAccountDetails(123123123));
			for (Transaction t : bankingServices.getAccountAllTransaction(123123123)) {
				System.out.println(t);
			}
			/*for (Account acc : bankingServices.findFew(5000)) {
				System.out.println(acc);
				
			}*/
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} catch (AccountBlockedException e) {
			e.printStackTrace();
		} catch (InsufficientAmountException e) {
			e.printStackTrace();
		} catch (InvalidPinNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
