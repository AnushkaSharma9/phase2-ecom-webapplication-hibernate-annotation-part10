package com.simplilearn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ecom_orders")
public class Order {
	
	// properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "order_name")
	private String name;

	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name = "customer_name")
	private String customerName;	
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Product> products;

	public Order(String name, Double totalPrice, String customerName, String customerPhone) {
		this.name = name;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", totalPrice=" + totalPrice + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", products=" + products + "]";
	}
	
}