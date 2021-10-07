package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecom_product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	@Column(name="dimention")
	private int dimention;
	@Column(name="brand")
	private String brand;
	@Column(name="weight")
	private int weight;
	@Column(name="stock")
	private int stock;
	
	public ProductDetails(String description, int dimention, String brand, int weight, int stock) {
		super();
		this.description = description;
		this.dimention = dimention;
		this.brand = brand;
		this.weight = weight;
		this.stock = stock;
	}


	public ProductDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripition() {
		return description;
	}

	public void setDescripition(String descripition) {
		this.description = descripition;
	}

	public int getDimention() {
		return dimention;
	}

	public void setDimention(int dimention) {
		this.dimention = dimention;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", descripition=" + description + ", dimention=" + dimention + ", brand="
				+ brand + ", weight=" + weight + ", stock=" + stock + "]";
	}
	
}