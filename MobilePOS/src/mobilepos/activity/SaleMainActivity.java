package mobilepos.activity;

import java.util.List;

import mobilepos.domain.Cart;
import mobilepos.domain.Inventory;
import mobilepos.domain.Item;
import mobilepos.domain.MockupInventory;

import com.example.mobilepos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SaleMainActivity extends Activity {
	private Button addToCartButton;
	private Button saleButton;
	private Button inventoryButton;
	private Button customerButton;
	private Button historyButton;
	private ListView itemInCartList;
	private TextView totalPrice;
	private List<Item> itemInCart;
	private Cart cart;
	private Inventory inventory;
	private String[] itemInCartListStringArr;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sale_main);
		
		addToCartButton = (Button)findViewById(R.id.sale_main_b_add_cart);
		itemInCartList = (ListView)findViewById(R.id.sale_main_itemlist);
		totalPrice = (TextView)findViewById(R.id.sale_main_t_price_total_cal);
		saleButton = (Button)findViewById(R.id.sale);
		inventoryButton = (Button)findViewById(R.id.inventory);
		historyButton = (Button)findViewById(R.id.history);
		customerButton = (Button)findViewById(R.id.customer);
		inventory = new MockupInventory();
		cart = Cart.getCartInstance();
		createItemListStringArr();
		
		saleButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Toast.makeText(getApplicationContext(),"Your current page is already Sale", Toast.LENGTH_LONG)
	  		               .show();
				}
	        });
	
	        
	        inventoryButton.setOnClickListener(new OnClickListener() {
	    		
	      	   
	    		@Override
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    			Intent goInventoryPage = new Intent(getApplicationContext(),MainActivity.class);
	    			startActivity(goInventoryPage);
	    		}
	    	});
	        
	       historyButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Toast.makeText(getApplicationContext(),"UnderConstruction", Toast.LENGTH_LONG)
	  		               .show();
				}
	        });
	       customerButton.setOnClickListener(new OnClickListener() {

	    			@Override
	    			public void onClick(View v) {
	    				// TODO Auto-generated method stub
	    			
	    				 Toast.makeText(getApplicationContext(),"UnderConstruction", Toast.LENGTH_LONG)
	      		               .show();
	    			}
	            });
	        
		
		
		
		addToCartButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (inventory.isEmpty()){
				Toast.makeText(getApplicationContext(),"Your inventory is empty\nPlease go to inventory to an item first", Toast.LENGTH_SHORT)
  		               .show();
				}
				else {
					Intent goSaleSelectItem = new Intent(getApplicationContext(),SaleSelectItemActivity.class);
	    			startActivity(goSaleSelectItem);
				}
			}
        });
		
	}
	
	public void createItemListStringArr(){
		
		
		itemInCart = cart.getItemListInCart();
    	if (itemInCart.size()!=0){
    		Log.d("create", "aaaaaaaaaaaaaaaaaa");
        	itemInCartListStringArr = new String[itemInCart.size()];
        	for (int i = 0; i < itemInCartListStringArr.length; i++) {
    			itemInCartListStringArr[i] =  itemInCart.get(i).getItemName();
    		}
        	
        	itemInCartList = (ListView)findViewById(R.id.sale_iii_itemlist);
    		ArrayAdapter<String> itemListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemInCartListStringArr);
    		  itemInCartList.setAdapter(itemListAdapter); 
    		    itemInCartList.setOnItemClickListener(new OnItemClickListener() {
    		    	   

    				@Override
    				public void onItemClick(AdapterView<?> parent, View view,
    		                int position, long id) {
    					// TODO Auto-generated method stub
    				
    					int itemPosition     = position;
    					 
    					 String  itemValue    = (String)itemInCartList.getItemAtPosition(position);
    		             
    		             // Show Alert 
    		             Toast.makeText(getApplicationContext(),
    		               "Position :"+itemPosition+"  ListItem : " +itemValue+"\nQuantity : "+itemInCart.get(position).getItemQnty()+" Brand : "+itemInCart.get(position).getItemBrand() , Toast.LENGTH_LONG)
    		               .show();
    		            
    					
    				}
    			});
        	}
    }

}
