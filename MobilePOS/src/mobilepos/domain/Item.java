package mobilepos.domain;

public class Item {
	private String itemName;
	private int itemQnty;
	private int itemQntyType;
	private String itemType;
	private String itemBrand;
	private int itemPrice;
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemBrand(String itemBrand){
		this.itemBrand = itemBrand;
	}
	public String getItemBrand(){
		return itemBrand;
	}
	public void setItemQnty(String itemQnty){
		this.itemQnty = Integer.parseInt(itemQnty);
	}
	public int getItemQnty(){
		return itemQnty;
	}
	public void setItemQntyType(String itemQnty){
		this.itemQnty = Integer.parseInt(itemQnty);
	}
	public int getItemQntyType(){
		return itemQnty;
	}
	public void setItemType(String itemQnty){
		this.itemQnty = Integer.parseInt(itemQnty);
	}
	public int getItemType(){
		return itemQnty;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = Integer.parseInt(itemPrice);
	}
	public int getItemPrice(){
		return itemPrice;
	}

	

}
