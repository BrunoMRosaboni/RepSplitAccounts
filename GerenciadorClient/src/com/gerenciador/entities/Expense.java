package com.gerenciador.entities;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Expense {
	
	private ArrayList<User> payers;
	private ArrayList<User> receivers;
	private double amount;
	private String reason;
	
	public Expense(ArrayList<User> payers, ArrayList<User> receivers, double amount, String reason) {
		super();
		this.payers = payers;
		this.receivers = receivers;
		this.amount = amount;
		this.reason = reason;
	}

	public ArrayList<User> getPayers() {
		return payers;
	}

	public ArrayList<User> getReceivers() {
		return receivers;
	}

	public double getAmount() {
		return amount;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "Pagantes: ";
		for (User user : payers) {
			if(user.equals(payers.get(0)))
				s+=user.getName();
			else
				s+=", "+ user.getName();
		}
		s+=" Valor: "+ String.format("%.2f", this.getAmount());
		s+=" Pra quem: ";
		for (User user : receivers) {
			if(user.equals(receivers.get(0)))
				s+=user.getName();
			else
				s+=", "+ user.getName();
		}
		return s;
	}


}
