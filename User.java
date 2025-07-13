package entity;

import java.util.Scanner;

public class User {
	private int userid;
	private String name;
	private String email;
	private String password;
	private String city;
	
	public User() {

	}
	
	public User(int userid, String name, String email, String password, String city) {
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void accept(Scanner sc) {
		System.out.print("Enter the user name - ");
		name = sc.next();
		System.out.print("Enter the email- ");
		email = sc.next();
		System.out.print("Enter the password - ");
		password = sc.next();
		System.out.print("Enter the city- ");
		city = sc.next();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password + ", city="
				+ city + "]";
	}
	
	
	


}
