package com.shoppingcart.main;

import java.util.Scanner;

import com.shoppingcart.model.IntialProducts;
import com.shoppingcart.model.Product;
import com.shoppingcart.repo.ShoppingCartRepo;
import com.shoppingcart.service.ShoppingCartService;

public class Shoppingcart {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
          
     ShoppingCartService shopping_service = new ShoppingCartService();
     IntialProducts intial_items= new IntialProducts();
     in = new Scanner(System.in);
     int choice;
     
     do {
			System.out.println(ANSI_PURPLE+"-------------------------------------------------------"+ANSI_RESET);
			System.out.println(ANSI_PURPLE + "                WELCOME TO SHOPPING CENTER ($)" + ANSI_RESET);
			System.out.println(ANSI_PURPLE+"-------------------------------------------------------"+ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   1.LIST PRODUCTS" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   2.ADD PRODUCT TO CART" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   3.DISPLAY YOUR CART" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   4.REMOVE PRODUCT FROM CART" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   5.CHECK OUT PRODUCT" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "                   6.Exit" + ANSI_RESET);
     
     
    System.out.println(ANSI_PURPLE + "ENTER YOUR CHOICE" + ANSI_RESET);
    choice = in.nextInt();
	switch (choice) {
     
	case 1:
     
     System.out.println(ANSI_BLUE+" PRODUCTS ARE"+ANSI_RESET);
     
     for(Product p : intial_items.getProducts())
     {
    	 System.out.println("Product id:"+ p.getP_id());
    	 System.out.println("Product Price:"+p.getPrice()); 
       	 System.out.println("Product name:"+p.getProduct_name());
    	 System.out.println("Product Details:"+p.getProduct_details());
    	 System.out.println("----------------------------------------");
    	 
     }
     break;
	case 2:
		System.out.println(ANSI_BLUE+"FOR ADDING PRODUCT ENTER PRODUCT ID"+ANSI_RESET);
		int p_id = in.nextInt();
		int isAdd = shopping_service.addShopcartService(p_id);
		if(isAdd==1)
		{
			
				System.out.println(ANSI_PURPLE+"--PRODUCT ADDED TO YOUR CARD SUCCESSFULLY--"+ANSI_RESET);
				
		}
		else
		{
			System.out.println(ANSI_PURPLE+"--PRODUCT NOT ADDED ,KINDLY INPUT CORRECT PRODUCT ID--"+ANSI_RESET);
		}
		 break;
	case 3:
		System.out.println(ANSI_BLUE+"YOUR CART PRODUCTS"+ANSI_RESET);
		System.out.println(ANSI_BLUE+"---------------------------"+ANSI_RESET);
		 shopping_service.displayProdInCartService();
			System.out.println(ANSI_BLUE+"---------------------------"+ANSI_RESET);
		 break;
	case 4:
		System.out.println(ANSI_BLUE+"ENTER PRODUCT ID TO REMOVE FROM YOUR CART"+ANSI_RESET);
		int pp_id=in.nextInt();
		boolean isRemove =shopping_service.removeShopCartService(pp_id);
		if(isRemove) {
			System.out.println(ANSI_PURPLE+"--PRODUCT REMOVED   FROM YOUR CARD SUCCESSFULLY--"+ANSI_RESET);
		}
		else
		{
			System.out.println(ANSI_PURPLE+"--PLEASE ENTER THE CARD PRODUCT ID COORECTLY TO REMOVE YOUR PRODUCT--"+ANSI_RESET);
		}
		break;
   
	case 5:
		System.out.println(ANSI_BLUE+"SELECT YOUR CREDIT CARD"+ANSI_RESET);
		System.out.println("1.GOLD");
		System.out.println("2.SILVER");
		System.out.println("3.NORMAL");
		int choices = in.nextInt();
		if(choices==1)
		{
			shopping_service.displayCheckOutProdService("GOLD");
		}
		else if(choices==2)
		{
			shopping_service.displayCheckOutProdService("SILVER");
		}
		else if(choices==3)
		{
			shopping_service.displayCheckOutProdService("NORMAL");
		}
		break;
		
	case 6:
		System.exit(1);
		break;
	 default:
         System.out.println("Please Enter a correct choice ....: )");
	}} while (choice!=6);
    
    
    
     
     
    
	}

}
