package com.gerenciador.entities;

public class User {
	
	public static final int ADMIN_ACCESS = 0;
	public static final int USER_ACCESS = 1;
	
	private String name;
	private String login;
	private String password;
	
	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		name = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	
//	private int accessLevel;
	
	

}
