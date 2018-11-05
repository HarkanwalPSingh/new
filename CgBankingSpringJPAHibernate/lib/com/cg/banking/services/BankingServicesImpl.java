package com.cg.banking.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoServices.AccountDAO;
import com.cg.banking.daoServices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component(value="bankingServices")
public class BankingServicesImpl implements BankingServices {
	
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account = new Account(1234, accountType, "Active", initBalance);
		account=accountDAO.save(account);
		return account.getAccountNo();
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = accountDAO.findById(accountNo).get();
		account.setAccountBalance(account.getAccountBalance()+amount);
		
		Transaction transaction = new Transaction(amount, "Deposit", account); 
		transactionDAO.save(transaction);
		
		accountDAO.save(account);
		
		return amount;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account = accountDAO.findById(accountNo).get();
		
		if((account.getAccountBalance()-amount)<0)
			throw new InsufficientAmountException("INSUFFICIENT FUNDS");
		else if(account.getPinNumber()!=pinNumber)
			throw new InvalidPinNumberException("INVALID PIN");
		else {
			account.setAccountBalance(account.getAccountBalance()-amount);
			
			Transaction transaction = new Transaction(amount, "Withdraw", account); 
			transactionDAO.save(transaction);
			
			accountDAO.save(account);
		}		
		return amount;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		Account accountFrom = accountDAO.findById(accountNoFrom).get();
		Account accountTo = accountDAO.findById(accountNoTo).get();
		accountFrom.setAccountBalance(accountFrom.getAccountBalance()-transferAmount);
		accountTo.setAccountBalance(accountTo.getAccountBalance()+transferAmount);
		
		Transaction transaction1 = new Transaction(transferAmount, "Deposit", accountTo); 
		transactionDAO.save(transaction1);
		
		Transaction transaction2 = new Transaction(transferAmount, "Withdraw", accountFrom); 
		transactionDAO.save(transaction2);
		
		accountDAO.save(accountFrom);
		accountDAO.save(accountTo);
		
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return accountDAO.findById(accountNo).get();
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return accountDAO.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return transactionDAO.findAll();
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		return accountDAO.findById(accountNo).get().getStatus();
	}

/*	@Override
	public ArrayList<Account> findFew(float balance) {
		return accountDAO.findFew(balance);
	}*/

}
