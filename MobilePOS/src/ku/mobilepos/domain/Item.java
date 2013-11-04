package ku.mobilepos.domain;

public class Item {
	private String itemId;
	private String itemName;
	private String itemBrand;
	private int itemQnty;
	private double itemPrice;
	private double itemBuyBahtPerPiece;
	
	/*
	 * set ItemId
	 * @param recieve itemId
	 */
	public void setItemId(String itemId){
		this.itemId = itemId;
	}
	
	/*
	 * get itemId
	 * @return itemId
	 */
	public String getItemId(){
		return itemId;
	}
	
	/*
	 * set ItemName
	 * @param recieve itemName
	 */
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	/*
	 * get item name
	 * @return item name
	 */
	public String getItemName(){
		return itemName;
	}
	
	/*
	 * set ItemBrand
	 * @param recieve itemBrand
	 */
	public void setItemBrand(String itemBrand){
		this.itemBrand = itemBrand;
	}
	
	/*
	 * get item brand
	 * @return itemBrand
	 */
	public String getItemBrand(){
		return itemBrand;
	}
	/*
	 * set Item Quantity
	 * @param recieve item quantity
	 */
	public void setItemQnty(String itemQnty){
		this.itemQnty = Integer.parseInt(itemQnty);
	}
	
	/*
	 * get item quantity
	 * @return item quantity
	 */
	public int getItemQnty(){
		return itemQnty;
	}

	/*
	 * set ItemPrice
	 * @param recieve item price
	 */
	public void setItemPrice(String itemPrice){
		this.itemPrice = Double.parseDouble(itemPrice);
	}
	
	/*
	 * get item price
	 * @return item price
	 */
	public double getItemPrice(){
		return itemPrice;
	}

	/*
	 * set ItemBuyBahtPerPiece
	 * @param recieve buy baht/piece
	 */
	public void setItemBuyBahtPerPiece(String itemBuyBahtPerPiece){
		this.itemBuyBahtPerPiece = Double.parseDouble(itemBuyBahtPerPiece);
	}
	
	/*
	 * get  ItemBuyBahtPerPiece
	 * @return item buyprice
	 */
	public double getItemBuyBahtPerPiece(){
		return itemBuyBahtPerPiece;
	}

	


}
