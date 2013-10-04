package com.example.mobilepos;

import java.util.ArrayList;
import java.util.List;

public class MockupInventory implements Inventory {
	private static List<Item> itemList = null;
	
	public static List<Item> getInstance(){
		
		if (itemList == null) itemList = new ArrayList<Item>();
		return itemList;
		
	}
	
	
	
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



	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return itemList;
	}
	
	

}
