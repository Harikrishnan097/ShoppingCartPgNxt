package com.shoppingcart.repo;

public interface IShoppingCartRepo {
	int addShopcart(int p_id);

	boolean removeShopCart(int p_id);

	void displayProdInCart();

	void displayCheckOutProd(String card_type);

}
