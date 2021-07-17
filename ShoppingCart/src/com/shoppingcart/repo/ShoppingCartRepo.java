package com.shoppingcart.repo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoppingcart.model.IntialProducts;
import com.shoppingcart.model.Product;

public class ShoppingCartRepo implements IShoppingCartRepo {

	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RESET = "\u001B[0m";

	
	Product product_d = new Product();
	List<Product> cproduct = new ArrayList<Product>();
	double sum = 0, discount;
	String pattern = "0.00";
	DecimalFormat decimalFormat = new DecimalFormat(pattern);

	public int addShopcart(int p_id) {

		List<Product> products = new IntialProducts().getProducts();

		Product prodadd = products.stream().filter(e -> e.getP_id() == p_id).findFirst().orElse(null);

		if (prodadd == null) {
			System.out.println("NO PRODUCT FOUNT TO BE ADDED");
			return 0;
		}
       System.out.println(prodadd.getProduct_name() + " ADDED SUCCESSFULLY");
		cproduct.add(prodadd);
		return 1;

	}

	public boolean removeShopCart(int p_id) {

		boolean product_check = cproduct.removeIf(p -> p.getP_id() == p_id);
       
		return product_check;

	}

	public void displayProdInCart() {

	

		for (Product p : cproduct) {
			System.out.println("Product id:" + p.getP_id());
			System.out.println("Product Price:" + p.getPrice());
			System.out.println("Product name:" + p.getProduct_name());
			System.out.println("Product Details:" + p.getProduct_details());
	

		}

	}

	

	public void displayCheckOutProd(String card_type) {

		Map<String, Integer> cards = new HashMap<String, Integer>();
		cards.put("GOLD", 20);
		cards.put("SILVER", 10);
		cards.put("NORMAL", 0);

		if (cards.get(card_type) > 0) {
			for (Product p : cproduct) {
				sum = sum + p.getPrice();
				discount = (sum * cards.get(card_type)) / 100;
			}
		} else {
			for (Product p : cproduct) {
				sum = sum + p.getPrice();
				discount = 0;
			}
		}

		for (Product p : cproduct) {
			System.out.println("Product id:" + p.getP_id());
			System.out.println("Product Price:" + p.getPrice());
			System.out.println("Product name:" + p.getProduct_name());
			System.out.println("Product Details:" + p.getProduct_details());
			System.out.println("----------------------------------------");

		}

		System.out.println("TOTAL AMOUNT: RS." + decimalFormat.format(sum));
		System.out.print("AS A ");
		System.out.print(ANSI_PURPLE + card_type + ANSI_RESET);
		System.out.println("  MEMBER DISCOUNTED:  RS." + decimalFormat.format(discount));
		System.out.println("-----------------");
		double total_price = sum - discount;
		System.out.println(ANSI_PURPLE + "TO BE PAID: RS." + decimalFormat.format(total_price) + ANSI_RESET);

	}

}
