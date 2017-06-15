package com.gerenciador.entities;

import java.util.ArrayList;

/**
 * Object to represent an expense made by a group of individuals.
 */

public class Expense {
	
	private ArrayList<User> payers;
	private ArrayList<User> receivers;
	private double amount;
	private String reason;
	
	/**
	 * Contructor.
	 * @param payers A list of the payers of the expense.
	 * @param receivers A list of the receivers of the payment.
	 * @param amount The amount payed.
	 * @param reason A justificative of the payment.
	 */
	
	public Expense(ArrayList<User> payers, ArrayList<User> receivers, double amount, String reason) {
		super();
		this.payers = payers;
		this.receivers = receivers;
		this.amount = amount;
		this.reason = reason;
	}
	
	/**
	 * The getter of 'payers'.
	 * @return The payers of this expense.
	 */

	public ArrayList<User> getPayers() {
		return payers;
	}
	
	/**
	 * The getter of 'receivers'.
	 * @return The receivers of the payment.
	 */

	public ArrayList<User> getReceivers() {
		return receivers;
	}
	
	/**
	 * The getter of 'amount'.
	 * @return The amount payed.
	 */

	public double getAmount() {
		return amount;
	}
	
	/**
	 * The getter of 'reason'.
	 * The reason of the payment.
	 */

	public String getReason() {
		return reason;
	}
	
	/**
	 * Function to be used at the UI of 'Pagamentos' to set the content in it.
	 * @return The string of the payments and payers of all expenses of the selected group.
	 */

	@Override
	public String toString() {
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
		s+=" Motivo: "+this.getReason();
		return s;
	}


}
