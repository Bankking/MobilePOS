package mobilepos.activity;

import mobilepos.domain.CurrentItem;
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
import android.widget.TextView;

public class InventoryShowItemInfoActivity extends Activity {
	private TextView itemName;
	private TextView itemBrand;
	private TextView itemQnty;
	private TextView itemPrice;
	private Button backButton;
	private Item item;
	private CurrentItem currentItem;
	private Inventory inventory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_item_info);
		currentItem = CurrentItem.getInstance();
		inventory = (Inventory) MockupInventory.getInstance();
		item = inventory.getItemByPostion(currentItem.getItemPosition());
		//if (item.getItemName().equals(null)){
		itemName.setText(item.getItemName());
		itemBrand.setText(item.getItemBrand());
		itemPrice.setText("Price: "+item.getItemPrice());
		itemQnty.setText("Quantity: "+item.getItemQnty());
		//}
		
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
