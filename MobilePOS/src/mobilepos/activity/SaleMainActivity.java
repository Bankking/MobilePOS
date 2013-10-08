package mobilepos.activity;

import java.util.List;

import mobilepos.domain.Inventory;
import mobilepos.domain.Item;
import mobilepos.domain.MockupInventory;

import com.example.mobilepos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SaleMainActivity extends Activity {
	private Button addToCartButton;
	private Button saleButton;
	private Button inventoryButton;
	private Button customerButton;
	private Button historyButton;
	private ListView itemInCartList;
	private TextView totalPrice;
	private List<Item> inventoryItemList;
	private Inventory inventory;
	
	
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
		inventoryItemList = MockupInventory.getInstance();
		
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

}
