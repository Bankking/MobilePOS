package mobilepos.domain;

import java.util.ArrayList;

public class CurrentItem {
	private static CurrentItem currentItem;
	private static Item item;
	private static int itemPosition;
	private CurrentItem(){
		
	}
	
	public static CurrentItem getInstance(){
		if (currentItem == null) currentItem = new CurrentItem();
		return currentItem;
	}
	
	public void setCurrentItem(Item item){
		this.item = item;
	}
	
	public void setItemPosition(int i){
		this.itemPosition = i;
	}
	
	public int getItemPosition(){
		return itemPosition;
	}
	
	public Item getCurrentItem(){
		return item;
	}
	

}
