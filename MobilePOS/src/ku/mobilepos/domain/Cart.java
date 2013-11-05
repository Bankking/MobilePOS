package ku.mobilepos.domain;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class Cart {
	private static Cart cart = null;
	private List<Item> itemInCart = null;
	private List<Integer> quantityItemInCart = null;
	private double totalSale;
	private Cart(){
		
	}
	
	public static Cart getCartInstance() {
		if (cart == null) cart = new Cart();
		return cart;
	}
	
	public List<Item> getItemListInCart() {
		if (itemInCart == null) {
			itemInCart = new ArrayList<Item>();
			quantityItemInCart = new ArrayList<Integer>();
		}
		return itemInCart;
	}
	
	public Integer getItemQuantity(int i){
		return quantityItemInCart.get(i);
	}
	
	public void addToCart(Item item) {
		boolean inCart = false;
		int position = 0;
		for (int i = 0; i < itemInCart.size(); i++) {
			if (item == itemInCart.get(i)){
				inCart = true;
				position = i;
			}
		}
		if (inCart){
			int j = quantityItemInCart.get(position);
			quantityItemInCart.set(position, j++);
			Log.d("aaaaaa", "aaaaaaaaaaaaaaa");
			
		}
		else {
			itemInCart.add(item);
			quantityItemInCart.add(1);
		}
		
		calculateSale(item);
		
	}
	
	public void removeItem(int position) {
		itemInCart.remove(position);
	}
	
	public void resetCart(){
		this.totalSale = 0.0;
		this.quantityItemInCart = null;
		this.itemInCart = null;
		this.cart = null;
	}
	
	public void calculateSale(Item item){
		
			totalSale += item.getItemPrice();
		
	}
	
	public double getTotalSale(){
		return totalSale;
	}
	

}
