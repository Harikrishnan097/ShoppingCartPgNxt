package com.shoppingcart.service;

import com.shoppingcart.repo.IShoppingCartRepo;
import com.shoppingcart.repo.ShoppingCartRepo;

public class ShoppingCartService {

	IShoppingCartRepo shoprepo = new ShoppingCartRepo();

	public int addShopcartService(int p_id) {

		return shoprepo.addShopcart(p_id);

	}

	public boolean removeShopCartService(int p_id) {
		return shoprepo.removeShopCart(p_id);
	}

	public void displayProdInCartService() {
		shoprepo.displayProdInCart();

	}

	public void displayCheckOutProdService(String card_type) {
		shoprepo.displayCheckOutProd(card_type);
	}

}
