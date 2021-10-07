package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecom_payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private int id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="price")
	private double price;

	public Payment(int id, String customerName, double price) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.price = price;
	}

	public Payment() {
		super();
	}

	public Payment(String customerName, double price) {
		super();
		this.customerName = customerName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", customerName=" + customerName + ", price=" + price + "]";
	}
	
}
