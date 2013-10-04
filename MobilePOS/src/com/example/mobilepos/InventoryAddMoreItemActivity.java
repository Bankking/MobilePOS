package com.example.mobilepos;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
	
public class InventoryAddMoreItemActivity extends Activity {
	private EditText itemName;
	private Button confirmButton;
	private Item newItem;
	private List<Item> inventory;
	
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_additem);
		
		inventory = MockupInventory.getInstance();
		newItem = new Item();
		itemName = (EditText)findViewById(R.id.inventory_amp_f_name);
		confirmButton = (Button)findViewById(R.id.inventory_amp_b_confirm);
		
		
		
		confirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				newItem.setItemName(itemName.getText().toString());
				Intent goInventory = new Intent(getApplicationContext(),MainActivity.class);
				inventory.add(newItem);
				startActivity(goInventory);
			}
		});
		
		
		
		
	}


}
