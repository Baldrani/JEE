package com.sdzee.servlets;

public class User {
	private String id;
	private String name;
	private String password;
	
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password= password;
	}
	
	public String toString() {
		return "Id : " + this.id + " / Name : " + this.name + " / Password : " + this.password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
