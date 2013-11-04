package ku.mobilepos.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private static Cart cart = null;
	private List<Item> itemInCart = null;
	private Cart(){
		
	}
	
	public static Cart getCartInstance() {
		if (cart == null) cart = new Cart();
		return cart;
	}
	
	public List<Item> getItemListInCart() {
		if (itemInCart == null) itemInCart = new ArrayList<Item>();
		return itemInCart;
	}
	
	public void addToCart(Item item) {
		itemInCart.add(item);
	}
	
	public void removeItem(int position) {
		itemInCart.remove(position);
	}
	

}
