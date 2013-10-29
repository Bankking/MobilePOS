package mobilepos.activity;

import java.util.List;

import mobilepos.domain.Item;
import mobilepos.domain.MockupInventory;

import com.example.mobilepos.R;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
	
public class InventoryAddMoreItemActivity extends Activity {
	private EditText itemName;
	private EditText itemQntyType;
	private RadioGroup itemQntyGroup;
	private RadioButton itemQntyTypeBox;
	private RadioButton itemQntyTypePiece;
	private EditText itemBrand;
	private EditText itemPrice;
	private Button confirmButton;
	private Button cancelButton;
	private Item newItem;
	private List<Item> inventory;
	
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_additem);
		
		inventory = MockupInventory.getInstance();
		newItem = new Item();
		createAllFindViewByID();
		
		cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				Intent goInventory = new Intent(getApplicationContext(),MainActivity.class);
				
				startActivity(goInventory);
			}
		});
		
		confirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				newItem.setItemName(itemName.getText().toString());
				//newItem.setItemType(itemQntyTypeBox.)
				newItem.setItemQnty(itemQntyType.getText().toString());
				newItem.setItemBrand(itemBrand.getText().toString());
				newItem.setItemPrice(itemPrice.getText().toString());
				
				inventory.add(newItem);
				
				Intent goInventory = new Intent(getApplicationContext(),MainActivity.class);
				
				startActivity(goInventory);
			}
		});
		
		
		
		
	}
	/**
	 * create all xx = findViewById(xxx);
	 */
	public void createAllFindViewByID(){
		itemName = (EditText)findViewById(R.id.inventory_amp_f_name);
		itemQntyType = (EditText)findViewById(R.id.inventory_amp_f_buyqntytype);
		itemBrand = (EditText)findViewById(R.id.inventory_amp_f_brand);
		itemPrice = (EditText)findViewById(R.id.inventory_amp_f_sellprice);
		confirmButton = (Button)findViewById(R.id.inventory_amp_b_confirm);
		cancelButton = (Button)findViewById(R.id.inventory_amp_b_cancel);
		itemQntyGroup = (RadioGroup) findViewById(R.id.inventory_amp_rbg_buyqnty);
		itemQntyTypeBox = (RadioButton) findViewById(R.id.inventory_amp_rb_box);
		itemQntyTypePiece = (RadioButton) findViewById(R.id.inventory_amp_rb_piece);
		
	}


}
