package com.gerenciador.entities;

import java.util.ArrayList;

/**
 * Object to represent a group in wich the users will share and control expenses.
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FinGroup {
	
	private ArrayList<User> users;
	private ArrayList<Expense> expenses;
	private String name;
	
	/**
	 * Constructor.
	 * @param users A list representing the users of the group.
	 * @param expenses A list representing the expenses of the group.
	 * @param name The name of the group.
	 */
	
	public FinGroup(ArrayList<User> users, ArrayList<Expense> expenses, String name) {
		super();
		this.users = users;
		this.expenses = expenses;
		this.name = name;
	}
	
	/**
	 * The getter of 'users'.
	 * @return The users of this group.
	 */

	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**
	 * The getter of 'expenses'.
	 * @return The expenses of this group.
	 */

	public ArrayList<Expense> getExpenses() {
		return expenses;
	}
	
	/**
	 * The getter of 'name'.
	 * @return name The name of the group.
	 */

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
	
	/**
	 * Function that calculates wich user shold pay to wich user to bring the balance of each one back to zero.
	 * @return A list with strings like this "'who should pay' -> 'to whom'('how much')"
	 */
	
	public ArrayList<String> getDebits(){
		
		ArrayList<String> out = new ArrayList<>();
		HashMap<String, Double> balances = this.getBalances();
		
		ArrayList<Double> debts = new ArrayList<Double>(balances.values());
		Collections.sort(debts);
		int i = 0, j = debts.size()-1;
//		System.out.println("i: "+i+" j:"+j+" size: "+debts.size());
		
		while(i<j&&debts.get(i)!=0){
			Double k = debts.get(i)+debts.get(j);
			String temp = "";
			if(k>0){
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(i)){
						temp = s + " -> ";
						break;
					}
				}
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(j)){
						temp+= (s+ String.format(" (R$ %.2f)", (-1)*debts.get(i)));
						balances.replace(s, k);
						break;
					}
				}
				out.add(temp);
				debts.remove(j);
				debts.add(j, k);
				i++;
			}
			else if(k==0){
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(i)){
						temp = s + " -> ";
						balances.replace(s, 0.0);
						break;
					}
				}
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(j)){
						temp+= (s+ String.format(" (R$ %.2f)", (-1)*debts.get(i)));
						balances.replace(s, 0.0);
						break;
					}
				}
				out.add(temp);
				i++;
				j--;
				
			}
			else if (k<0){
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(i)){
						temp = s + " -> ";
						balances.replace(s, k);
						break;
					}
				}
				for (String s : balances.keySet()) {
					if(balances.get(s)==debts.get(j)){
						temp+= (s+ String.format(" (R$ %.2f)", debts.get(j)));
						break;
					}
				}
				out.add(temp);
				debts.remove(i);
				debts.add(i, k);
				j--;
			}
		}
		
//		Double moreNegative = Collections.min(balances.values());
//		Double morePositive = Collections.max(balances.values());
//		
//		if(moreNegative+morePositive>=0)
//		{
//			for (String s : balances.keySet()) {
//				if(balances.get(s)==moreNegative); 
//			}
//		}
//			
		
		
		
		return out;
	}

}
