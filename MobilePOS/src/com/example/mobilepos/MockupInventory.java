package com.example.mobilepos;

import java.util.ArrayList;
import java.util.List;

public class MockupInventory implements Inventory {
	public List<Item> itemList = new ArrayList<Item>();
	
	@Override
	public void addItem(Item i) {
		// TODO Auto-generated method stub
		itemList.add(i);
	}

	@Override
	public void removeItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item getItem(String itemName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemName().equals(itemName)){
				return itemList.get(i);
			}
		}
		return null;
	}

}
