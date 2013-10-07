package com.example.mobilepos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InventoryShowItemInfoActivity extends Activity {
	private TextView itemName;
	private TextView itemBrand;
	private TextView itemQnty;
	private TextView itemPrice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_item_info);
	}

}
