package com.simplilearn.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// This is a encapsulated POJO
@Entity
@Table(name="ecom_product")
public class Product {

	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_price")
	private Double price;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="modified_at")
	private Date modifiedAt;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private ProductDetails details;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Order order;
	
	public Product() {
		super();
	}

	public Product(int id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
		this.createdAt = new Date();
		this.modifiedAt = new Date();
	}

	// get & set 
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public ProductDetails getDetails() {
		return details;
	}

	public void setDetails(ProductDetails details) {
		this.details = details;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + "]";
	}
	
}