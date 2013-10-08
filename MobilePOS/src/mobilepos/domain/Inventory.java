package mobilepos.domain;

import java.util.List;


public interface Inventory {
	public void addItem(Item i);
	public void removeItem();
	public Item getItemByName(String itemName);
	public Item getItemByPostion(int i);
	public List<Item> getItemList();
	

}
