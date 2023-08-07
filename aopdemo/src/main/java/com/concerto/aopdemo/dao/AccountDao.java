package com.concerto.aopdemo.dao;

import java.util.List;

import com.concerto.aopdemo.Account;

public interface AccountDao {

	//add a new method : findAccounts();
	
	List<Account> findAccounts();
	
	void addAccount();
	
	void addAccount(Account account, boolean vip);
	
	boolean doWork();
	
	public String getName();

	public void setName(String name); 

	public String getServiceCode();

	public void setServiceCode(String serviceCode);

	List<Account> findAccounts(boolean tripWire);
}
