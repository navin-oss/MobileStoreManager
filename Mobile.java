package entity;

import java.util.Scanner;

public class Mobile { 
	private int mobileid;
	private String company;
	private String model;
	private double price;
	public Mobile() {
		// TODO Auto-generated constructor stub
	}
	public Mobile(int mobileid, String company, String model, double price) {
		this.mobileid = mobileid;
		this.company = company;
		this.model = model;
		this.price = price;
	}
	
	public int getMobileid() {
		return mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [mobileid=" + mobileid + ", company=" + company + ", model=" + model + ", price=" + price + "]";
	}
	public void accept(Scanner sc) {
		System.out.print("Enter the company - ");
		company = sc.next();
		System.out.print("Enter the model - ");
		model = sc.next();
		System.out.print("Enter the price - ");
		price = sc.nextDouble();

	}

}
