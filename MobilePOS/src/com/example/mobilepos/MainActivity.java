package com.example.mobilepos;

import java.util.List;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button addButton;
	private ListView allItemList;
	private List<Item> inventory;
	private String[] inventoryListStringArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_main);
    	
        inventory = MockupInventory.getInstance();
        createItemListStringArr();
    	
       addButton = (Button)findViewById(R.id.inventory_b_additem);
       
   
       
       
       addButton.setOnClickListener(new OnClickListener() {
		
    	   
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent goAddMoreProduct = new Intent(getApplicationContext(),InventoryAddMoreItemActivity.class);
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
    				public void onItemClick(AdapterView<?> parent, View view,
    		                int position, long id) {
    					// TODO Auto-generated method stub
    					 int itemPosition     = position;
    					 
    					 String  itemValue    = (String)allItemList.getItemAtPosition(position);
    		             
    		             // Show Alert 
    		             Toast.makeText(getApplicationContext(),
    		               "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
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
