package com.shoppingcart.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private int p_id;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	private String product_name;
	private double price;
	private String product_details;
	
	
	
	
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", product_name=" + product_name + ", price=" + price + ", product_details="
				+ product_details + "]";
	}
	public Product(int p_id, String product_name, double price, String product_details) {
		super();
		this.p_id = p_id;
		this.product_name = product_name;
		this.price = price;
		this.product_details = product_details;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduct_details() {
		return product_details;
	}
	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}
	
	public Product()
	{}
	
	

}
