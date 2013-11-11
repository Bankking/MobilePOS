package ku.mobilepos.activity;

import ku.mobilepos.domain.Inventory;
import ku.mobilepos.domain.Item;
import ku.mobilepos.domain.MockupInventory;

import com.example.mobilepos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InventoryShowItemInfoActivity extends Activity {
	/** text view name of product */
	private TextView itemName;
	/** text view brand of product */
	private TextView itemBrand;
	/** text view quantity of product */
	private TextView itemQnty;
	/** text view cost of product */
	private TextView itemPrice;
	
	/** button back */
	private Button backButton;
	private Item item;
	
	private Inventory inventory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_item_info);
		
		inventory = (Inventory) MockupInventory.getInstance();
		
		//if (item.getItemName().equals(null)){
		itemName.setText(item.getItemName());
		itemBrand.setText(item.getItemBrand());
		itemPrice.setText("Price: "+item.getItemPrice());
		itemQnty.setText("Quantity: "+item.getItemQnty());
		
		backButton = (Button)findViewById(R.id.inventory_ii_b_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent goToInventory = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(goToInventory);
			}
		});
	}
}
