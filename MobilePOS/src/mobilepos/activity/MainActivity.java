package mobilepos.activity;

import java.util.List;

import mobilepos.domain.CurrentItem;
import mobilepos.domain.Item;
import mobilepos.domain.MockupInventory;

import com.example.mobilepos.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button addButton;
	private Button inventoryButton;
	private Button saleButton;
	private Button customerButton;
	private Button historyButton;
	private ListView allItemList;
	private List<Item> inventory;
	private String[] inventoryListStringArr;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_main);
        
        inventoryButton = (Button) findViewById(R.id.inventory);
        saleButton = (Button) findViewById(R.id.sale);
        customerButton = (Button) findViewById(R.id.customer);
        historyButton = (Button) findViewById(R.id.history);
        
        inventoryButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"Your current page is already Inventory", Toast.LENGTH_LONG)
  		        .show();
			}
        });
        
        saleButton.setOnClickListener(new OnClickListener() {  	   
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			Intent goSalePage = new Intent(getApplicationContext(),SaleMainActivity.class);
    			startActivity(goSalePage);
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
        
        inventory = MockupInventory.getInstance();
        createItemListStringArr();
        addButton = (Button)findViewById(R.id.inventory_b_additem);
        addButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Intent goAddMoreProduct = new Intent(getApplicationContext(), InventoryAddMoreItemActivity.class);
        		startActivity(goAddMoreProduct);
        	}
        });
    }  
 
    public void createItemListStringArr(){
    	if (inventory.size()!=0){
        	inventoryListStringArr = new String[inventory.size()];
        	for (int i = 0; i < inventoryListStringArr.length; i++) {
    			inventoryListStringArr[i] =  inventory.get(i).getItemName();
    		}
        	
        	allItemList = (ListView)findViewById(R.id.inventory_itemlist);
    		ArrayAdapter<String> itemListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, inventoryListStringArr);
    		allItemList.setAdapter(itemListAdapter); 
    		allItemList.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    				// TODO Auto-generated method stub
    				/*
    				CurrentItem currentItem = CurrentItem.getInstance();
    		        currentItem.setCurrentItem(inventory.get(position));
    		        currentItem.setItemPosition(position);            
     				Intent goItemInfo = new Intent(getApplicationContext(),InventoryShowItemInfoActivity.class);
     				startActivity(goItemInfo);
    				*/
    				int itemPosition = position;
    				String  itemValue = (String)allItemList.getItemAtPosition(position);            
    		        // Show Alert 
    		        Toast.makeText(getApplicationContext(),
    		        "Position :"+itemPosition+"  ListItem : " +itemValue+"\nQuantity : "+inventory.get(position).getItemQnty()+" Brand : "+inventory.get(position).getItemBrand() , Toast.LENGTH_LONG)
    		        .show();
    			}
    		});
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
