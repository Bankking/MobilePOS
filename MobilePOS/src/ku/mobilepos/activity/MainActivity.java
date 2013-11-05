package ku.mobilepos.activity;

import java.util.List;

import ku.mobilepos.domain.CurrentItem;
import ku.mobilepos.domain.Inventory;
import ku.mobilepos.domain.Item;
import ku.mobilepos.domain.MockupInventory;


import com.example.mobilepos.R;
import ku.mobilepos.activity.IntentIntegrator;
import ku.mobilepos.activity.IntentResult;

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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** add button for add product to cart */
	private Button addButton;
	/** inventory button for go to inventory */
	private Button inventoryButton;
	/** sale button */
	private Button saleButton;
	/** customer button */
	private Button customerButton;
	/** history button */
	private Button historyButton;
	
	/** list of product */
	private ListView allItemList;
	private Inventory inventory;
	private String[] inventoryListStringArr;
	
	private Button scanBtn;
  	private TextView formatTxt, contentTxt;
	
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
    	
        
        /**
         * when select Sale button it will go to Sale page
         */
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
    	if (inventory.getItemList().size()!=0){
        	inventoryListStringArr = new String[inventory.getItemList().size()];
        	for (int i = 0; i < inventoryListStringArr.length; i++) {
    			inventoryListStringArr[i] =  "Product Name: "+inventory.getItemList().get(i).getItemName()+"\n Sell Price: "
        	+inventory.getItemList().get(i).getItemPrice()
        	+"\n Quantity: "+inventory.getItemList().get(i).getItemQnty();
    		}
        	
        	allItemList = (ListView)findViewById(R.id.inventory_itemlist);
    		ArrayAdapter<String> itemListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, inventoryListStringArr);
    		allItemList.setAdapter(itemListAdapter); 
    		allItemList.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    				// TODO Auto-generated method stub
    				
    				int itemPosition = position;
    				String  itemValue = (String)allItemList.getItemAtPosition(position);            
    		        // Show Alert 
    		        Toast.makeText(getApplicationContext(),
    		        "Position :"+itemPosition+"  ListItem : " +itemValue+"\nQuantity : "+inventory.getItemByPostion(position).getItemQnty()+" Brand : "+inventory.getItemByPostion(position).getItemBrand() , Toast.LENGTH_LONG)
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
