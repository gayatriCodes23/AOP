package com.concerto.aopdemo;

public class Account {

	private String name;

	private String level;

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	public Account() {
	}

	public String getName() {
		System.out.println(getClass() + "getName");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "setName");

		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

}
