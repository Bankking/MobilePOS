package ku.mobilepos.activity;

import java.util.List;

import ku.mobilepos.controller.CartController;
import ku.mobilepos.controller.InventoryController;
import ku.mobilepos.domain.Inventory;
import com.example.mobilepos.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryAddMoreItemActivity extends Activity {
	/** name of product */
	private EditText itemName;
	/** type of product quantity */ 
	private EditText itemQntyType;
	/** brand of product */	
	private EditText itemBrand;
	/** cost of product */
	private EditText itemPrice;
	/** cost of one product per box */
	//private EditText itemPiecePerBox;
	/** id of product */
	private EditText itemProductId;
	/** cost of product per box */
	private EditText itemBuyPricePerBox;
	
	/** text view of product */
	private TextView itemBuyPriceCal;
	/** text view to enter cost of product */
	private TextView itemBuyPriceText;
	/** text view of type of product */
	private TextView itemBuyType;
	/** text view of cost of product by bath */
	private TextView itemBuyBahtPerType;
	private TextView formatTxt;
	private TextView contentTxt;
	
	/** button to confirm for add product */
	private Button confirmButton;
	/** button to cancel product */
	private Button cancelButton;
	/** button to check duplicate product */
	private Button checkButton;
	/** button to scan product by using barcode scanner */
	private Button scanBtn;
	
	private CartController newItem;
	/** create inventory */
	private Inventory inventory;
	
	/** cost per piece */
	private String pricePerPiece;

	private Button buttonScan;
	private static final int SCANNER_ACTIVITY_REQUESTCODE = 49374;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_additem);
		inventory = InventoryController.getInstance();
		//itemList = inventory.getItemList();
		newItem = new CartController();
		createAllFindViewById();
		setAllEditTextToOneLine();
        
		/**
		 * when select cancel button it will go back to inventory page
		 */
		cancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent goInventory = new Intent(getApplicationContext(),
				MainActivity.class);

				startActivity(goInventory);
			}
		});
		
		/**
		 * when select confirm button it will add new item to inventory and go back to inventory page
		 */
		confirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(itemName.getText().toString().equals("") 
				|| itemBrand.getText().toString().equals("") 
				|| itemPrice.getText().toString().equals("") )
				{
					Toast.makeText(getApplicationContext(),"Please fill all blank.", Toast.LENGTH_LONG)
	  		        .show();
				}
				else
				{
					newItem.setItemId(itemProductId.getText().toString());
					newItem.setItemName(itemName.getText().toString());
					newItem.setItemBrand(itemBrand.getText().toString());
					String totalPiece;
					totalPiece = calculateTotalPiece(itemQntyType.getText().toString());
					newItem.setItemQnty(totalPiece);
					newItem.setItemBuyPiece(itemQntyType.getText().toString());
					newItem.setItemPrice(itemPrice.getText().toString());
					newItem.setItemBuyPriceBahtPerBox(itemBuyPricePerBox.getText().toString());
					inventory.addItem(newItem);
					ShowDialog();					
				}
			}
		});

		/**
		 * check if product is already in inventory
		 */
		checkButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (itemProductId.getText() != null){
					
					//newItem.setItemId(itemProductId.getText().toString());
					if (inventory.getItemById(itemProductId.getText().toString())!=null){
						CartController item = inventory.getItemById(itemProductId.getText().toString());
						itemName.setText(item.getItemName());
						itemBrand.setText(item.getItemBrand());
						itemQntyType.setText(item.getItemBuyPiece());
						itemBuyPricePerBox.setText(""+item.getItemBuyPriceBahtPerBox());
						//itemPiecePerBox.setText(""+item.getItemPiecePerBox());
						itemBuyPriceCal.setText("  "+item.getItemPricePerPiece()+"  ");
						itemPrice.setText(""+item.getItemPrice());
					}
				}
			}
		});
		
		buttonScan = (Button) findViewById(R.id.buttonScan);
		//OnClickListener scanListener = new ScanProduct(this);
		//buttonScan.setOnClickListener(scanListener);
		
	}
	
	public void ShowDialog()
	{
        final AlertDialog.Builder dDialog = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);

    	dDialog.setTitle("Phone number ");
    	dDialog.setMessage("Please input your phone number :");
    	dDialog.setIcon(android.R.drawable.stat_sys_upload_done); 
    	dDialog.setView(input);
    	
    	// Ok
    	dDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			String value = input.getText().toString();
    			Intent goInventory = new Intent(getApplicationContext(),
						MainActivity.class);	
    			startActivity(goInventory);
    		  }
    		});
    	
    	// Cancel
    	dDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		  public void onClick(DialogInterface dialog, int whichButton) {
    			  String value = input.getText().toString();
    		  }
    		});
    	
    	dDialog.show();
    	
	}
	
	/**
	 * a = number of box, b = p = cost per box
	 * @param box is number of total box
	 * @param piecePerBox is cost per box
	 * @return a * b or total cost of all box
	 */
	public String calculateTotalPiece(String box){
		int a = Integer.parseInt(box);
		return a+"";
	}
	
	/**
	 * a is box, b is total bath
	 * @param box is number of total box
	 * @param totalBaht is total cost in unit baht
	 * @return a * b or total cost of box in unit baht
	 */
	public String calculateTotalBuyBaht(String box,String totalBaht){
		int a = Integer.parseInt(box),b = Integer.parseInt(totalBaht);
		return a*b+"";
	}
	
	/**
	 * create attribute b for convert string of price to integer
	 * @param piece total quantity of product
	 * @param price is cost of product
	 * @return price / piece
	 */
	public String calculatePricePerPiece(int piece, String price){
		double b = Double.parseDouble(price);
		return b/piece+"";
	}

	/**
	 * create all xx = findViewById(xxx);
	 */
	public void createAllFindViewById() {
		//EditText
		itemName = (EditText) findViewById(R.id.inventory_amp_f_name);
		itemQntyType = (EditText) findViewById(R.id.inventory_amp_f_buyqntytype);
		itemBrand = (EditText) findViewById(R.id.inventory_amp_f_brand);
		itemPrice = (EditText) findViewById(R.id.inventory_amp_f_sellprice);
		//itemPiecePerBox = (EditText) findViewById(R.id.inventory_amp_f_pieceperbox);
		itemProductId = (EditText) findViewById(R.id.inventory_amp_f_productid);
		itemBuyPricePerBox = (EditText) findViewById(R.id.inventory_amp_f_buypricebathperbox);
		
		//Button
		confirmButton = (Button) findViewById(R.id.inventory_amp_b_confirm);
		cancelButton = (Button) findViewById(R.id.inventory_amp_b_cancel);
		checkButton = (Button) findViewById(R.id.inventory_amp_b_check);
		scanBtn = (Button)findViewById(R.id.buttonScan);      
		
		//TextView
		itemBuyType = (TextView) findViewById(R.id.inventory_amp_t_buyqntytype);
		//itemBuyPriceText = (TextView) findViewById(R.id.inventory_amp_t_pieceperbox);
		itemBuyBahtPerType = (TextView) findViewById(R.id.inventory_amp_t_buypricebathpertype);
		itemBuyBahtPerType.setText("Baht/Piece :");
		formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
	}

	
	/**
	 * Set all EditText to be one single line
	 */
	public void setAllEditTextToOneLine(){
		setMaxLineText(itemName);
		setMaxLineText(itemBrand);
		//setMaxLineText(itemPiecePerBox);
		setMaxLineText(itemPrice);
		setMaxLineText(itemQntyType);
		setMaxLineText(itemProductId);
		
	}
	
	/**
	 * update text price per piece
	 * @param mEditText receive mEditText
	 */
	public void updatePricePerPiece(EditText mEditText){
		mEditText.setOnKeyListener(new View.OnKeyListener() {       
	        public boolean onKey(View v, int keyCode, KeyEvent event) {
	            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
	            	itemBuyPriceCal.setText("  "+pricePerPiece+"  ");	
	            }
	            return false;
	        }
		});
	}
	
	/**
	 * Set EditText to be one single line (cannot press enter to enter the new line) 
	 */
	public void setMaxLineText(EditText mEditText){
		mEditText.setOnKeyListener(new View.OnKeyListener() {
	        public boolean onKey(View v, int keyCode, KeyEvent event) {
	        	if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
	        		String text = ((EditText) v).getText().toString();
	        		int editTextRowCount = text.split("\\n").length;
	                if (editTextRowCount >= 1) 
	                {
	                    int lastBreakIndex = text.lastIndexOf("\n");
	                    String newText = Integer.toString(lastBreakIndex);
	                    newText = text.substring(0);
	                    ((EditText) v).setText("");
	                    ((EditText) v).append(newText);
	                }
	            }
	            return false;
	        }
		});
	}
}
	
