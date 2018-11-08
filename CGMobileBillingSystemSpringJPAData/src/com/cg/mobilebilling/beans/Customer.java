package com.cg.mobilebilling.beans;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	private int customerID;
	private String firstName, lastName, emailID, dateOfBirth;
	private Address billingAddress;
	private Map<Long, PostpaidAccount> postpaidAccounts;
	public Customer() {}
	
}