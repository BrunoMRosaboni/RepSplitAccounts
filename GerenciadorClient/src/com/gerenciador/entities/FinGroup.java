package com.gerenciador.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class FinGroup {
	
	private ArrayList<User> users;
	private ArrayList<Expense> expenses;
	private String name;
	
	public FinGroup(ArrayList<User> users, ArrayList<Expense> expenses, String name) {
		super();
		this.users = users;
		this.expenses = expenses;
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Expense> getExpenses() {
		return expenses;
	}

	public String getName() {
		return name;
	}
	/**
	 * 
	 * Function that calculates the individual balance of each user in the group
	 * @return a hashMap objet in wich the key is the user name, and the value is his current balance
	 * @author raulp
	 */
	public HashMap<String, Double> getBalances(){
		HashMap<String, Double> balances = new HashMap<>();
		for (User u : users) {
			balances.put(u.getName(), 0.0);
		}
		
		for (Expense e : expenses) {
			int creditDivider = e.getPayers().size();
			int debitDivider = e.getReceivers().size();
			
			for (User u : e.getPayers()) {
				balances.replace(u.getName(), balances.get(u.getName())+(e.getAmount()/creditDivider));
			}
			
			for (User u : e.getReceivers()) {
				balances.replace(u.getName(), balances.get(u.getName())-(e.getAmount()/debitDivider));
			}
		}
		
		return balances;
	}

}
