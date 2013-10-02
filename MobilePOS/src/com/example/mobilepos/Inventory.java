package com.example.mobilepos;

public interface Inventory {
	public void addItem(Item i);
	public void removeItem();
	public Item getItem(String itemName); 

}
