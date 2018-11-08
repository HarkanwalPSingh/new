package com.cg.mobilebilling.beans;
import java.util.HashMap;
import java.util.Map;

public class PostpaidAccount {
	private long mobileNo;
	private Plan plan;
	private  Map<Integer, Bill> bills;
	public PostpaidAccount() {}
	
}