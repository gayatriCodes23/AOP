package com.concerto.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {



	@Override
	public void addSillyMember() {
		System.out.println(getClass() + " DOING DB WORK: ADDING silly ACCOUNT");

		
	}

	@Override
	public void goToSleep() {
		System.out.println(getClass() + "going to sleep");
		
	}

}
