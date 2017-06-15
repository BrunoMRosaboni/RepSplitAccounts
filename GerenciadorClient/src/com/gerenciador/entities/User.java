package com.gerenciador.entities;

/**
 * Object to represent a user of the app.
 */

public class User {
	
	public static final int ADMIN_ACCESS = 0;
	public static final int USER_ACCESS = 1;
	
	private String name;
	private String login;
	private String password;
	
	/**
	 * Constructor.
	 * @param name The name of the user.
	 * @param login The username of the user.
	 * @param password The password of the user.
	 */
	
	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	/**
	 * Constructor.
	 * @param login The login of the user.
	 * @param password The password of the user. 
	 */
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		name = null;
	}
	
	/**
	 * The getter of 'name'
	 * @return The name of the user.
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * The setter of 'name'
	 * @param name The name of the user.
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * The getter of 'login'.
	 * @return The username of the user.
	 */

	public String getLogin() {
		return login;
	}
	
	/**
	 * The getter of 'password'
	 * @return The password of the user.
	 */

	public String getPassword() {
		return password;
	}

	
//	private int accessLevel;
	
	

}
