package ku.mobilepos.activity;


import ku.mobilepos.domain.CustomerList;
import ku.mobilepos.domain.MockupCustomerList;


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

public class CustomerMainActivity extends Activity {
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
	private ListView allCustomerList;
	private CustomerList customerList;
	private String[] customerListStringArr;
	

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_main);
        
        inventoryButton = (Button) findViewById(R.id.inventory);
        saleButton = (Button) findViewById(R.id.sale);
        customerButton = (Button) findViewById(R.id.customer);
        historyButton = (Button) findViewById(R.id.history);
        
        
        inventoryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent goInventoryPage = new Intent(getApplicationContext(),MainActivity.class);
    			startActivity(goInventoryPage);
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
    			Toast.makeText(getApplicationContext(),"Your current page is already Customer", Toast.LENGTH_LONG)
  		        .show();
    		}
        });
        
        customerList = MockupCustomerList.getInstance();
        createItemListStringArr();
        addButton = (Button)findViewById(R.id.cus_b_addcus);
        addButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		 Toast.makeText(getApplicationContext(),"UnderConstruction", Toast.LENGTH_LONG)
  		         .show();
        		//Intent goAddMoreProduct = new Intent(getApplicationContext(), InventoryAddMoreItemActivity.class);
        		//startActivity(goAddMoreProduct);
        	}
        });
    }  
 
    public void createItemListStringArr(){
    	if (customerList.getCustomerList().size()!=0){
        	customerListStringArr = new String[customerList.getCustomerList().size()];
        	for (int i = 0; i < customerListStringArr.length; i++) {
    			customerListStringArr[i] =  "\nName: "+customerList.getCustomerList().get(i).getCusName().toString() +"\nPhoneNo.: "
    										+customerList.getCustomerList().get(i).getCusPhoneNo();
    		}
        	
        	allCustomerList = (ListView)findViewById(R.id.inventory_itemlist);
    		ArrayAdapter<String> itemListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, customerListStringArr);
    		allCustomerList.setAdapter(itemListAdapter); 
    		allCustomerList.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    				// TODO Auto-generated method stub
    				
    				int itemPosition = position;
    				String  itemValue = (String)allCustomerList.getItemAtPosition(position);            
    		        // Show Alert 
    		        Toast.makeText(getApplicationContext(),
    		        		"\nName: "+customerList.getCustomerList().get(itemPosition).getCusName().toString() +"\nPhoneNo.: "
									+customerList.getCustomerList().get(itemPosition).getCusPhoneNo() , Toast.LENGTH_LONG)
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
