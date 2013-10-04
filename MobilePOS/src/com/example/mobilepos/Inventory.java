package com.example.mobilepos;

import java.util.List;

public interface Inventory {
	public void addItem(Item i);
	public void removeItem();
	public Item getItem(String itemName); 
	public List<Item> getItemList();

}
