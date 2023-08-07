package com.concerto.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concerto.aopdemo.dao.AccountDao;
import com.concerto.aopdemo.dao.MembershipDao;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {

		return runner -> {

//			demoTheBeforeAdvice(accountDao, membershipDao);
//			demoAfterReturnngAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
			demoTheAfterAdvice(accountDao);

		};
	}

	private void demoTheAfterAdvice(AccountDao accountDao) {

		// call method to find account
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exception

			boolean tripWire = true;
			theAccounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Cought exception:" + e);
		}
		// display the accounts
		System.out.println("Main program: demoAfterReturnngAdvice");
		System.out.println("=======================================");
		System.out.println(theAccounts);
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		accountDao.addAccount();
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Silver");
		accountDao.addAccount(account, true);

		accountDao.setName("Foobar");
		accountDao.setServiceCode("Silver");

		String name = accountDao.getName();
		String service = accountDao.getServiceCode();

		membershipDao.addSillyMember();
		membershipDao.goToSleep();

	}

	private void demoAfterReturnngAdvice(AccountDao accountDao) {

		// call method to find account

		List<Account> thAccounts = accountDao.findAccounts();

		// display the accounts
		System.out.println("Main program: demoAfterReturnngAdvice");
		System.out.println("=======================================");
		System.out.println(thAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
		// call method to find account
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exception

			boolean tripWire = true;
			theAccounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Cought exception:" + e);
		}
		// display the accounts
		System.out.println("Main program: demoAfterReturnngAdvice");
		System.out.println("=======================================");
		System.out.println(theAccounts);
	}

}
