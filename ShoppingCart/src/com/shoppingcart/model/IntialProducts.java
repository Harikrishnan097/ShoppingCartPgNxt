package com.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;


public class IntialProducts {

	List<Product> products = new ArrayList<>();
	
	
	
	



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public IntialProducts() {
		// TODO Auto-generated constructor stub
		products.add( new Product(1001,"BREAD",20.00,"Tasty bread "));
		products.add( new Product(1002,"BABY OIL",200.56,"Soft and secure for babies"));
		products.add( new Product(1003,"REDMI 7",19999,"Fast and good"));
		products.add( new Product(1004,"I PHONE 8",70000,"Standard product"));
		products.add( new Product(1005,"ASUS ROG 5",45000,"Good for Gamers"));
	}
	
}
