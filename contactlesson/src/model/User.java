package model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String email;
	private String massage;
	public User(String name, String email, String massage) {
		super();
		this.name = name;
		this.email = email;
		this.massage = massage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}

}
