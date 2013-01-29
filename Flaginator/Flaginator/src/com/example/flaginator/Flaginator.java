package com.example.flaginator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.content.DialogInterface;

public class Flaginator extends Activity implements OnClickListener {

	public static final int chosen_mode = 10;
	public static int CHOSEN_MODE = 0;
	public static final String PREF_NAME = "MySettingsFile";
	int i_mode = 0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flaginator);
        
        View startButton = this.findViewById(R.id.btnStart);
        startButton.setOnClickListener(this);
        View settingsButton = this.findViewById(R.id.btnMode);
        settingsButton.setOnClickListener(this);
        View scoreButton = this.findViewById(R.id.btnScore);
        scoreButton.setOnClickListener(this);
        View infoButton = this.findViewById(R.id.btnInfo);
        infoButton.setOnClickListener(this);
        View exitButton = this.findViewById(R.id.btnExit);
        exitButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_flaginator, menu);
        return true;
    }

	public void onClick(View v) {
		Intent i;
		
		final Item[] items = {
				new Item("Europe",R.drawable.geurope),
				new Item("Azia",R.drawable.gasia),
				new Item("Africa",R.drawable.gafrica),
				new Item("Americas and Caribbean",R.drawable.gamericas)
		};
		
		
		ListAdapter adapter = new ArrayAdapter<Item>(
				this, 
				android.R.layout.simple_list_item_1,
				android.R.id.text1,
				items) {
					public View getView(int position, View convertView, ViewGroup parent){
						View v = super.getView(position, convertView, parent);
						TextView tv = (TextView)v.findViewById(android.R.id.text1);
						
						tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);
						
						int dp5 = (int)(5 * getResources().getDisplayMetrics().density + 0.5f);
						tv.setCompoundDrawablePadding(dp5);
						
						return v;
					}
		};
		
		switch (v.getId()) {
		case R.id.btnStart:
			
			SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
	        i_mode = settings.getInt("mode", 0);
			
			new AlertDialog.Builder(this)
			.setTitle("Choose continent")
			.setCancelable(false)
			.setAdapter(adapter, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {

					Intent intent;
					//if (CHOSEN_MODE == 0) {  ak pouzijem Setting.java (vtedy sa mi automaticky po zvoleni modu ulozi jednorazovo mod hry)
					if(i_mode == 0) {
						intent = new Intent(getBaseContext(),StartCapital.class);
					}
			        else {
			        	intent = new Intent(getBaseContext(),StartFlag.class);
			        }
					intent.putExtra("continent", which);
					startActivity(intent);
				}
			}).show();
			break;
		case R.id.btnMode:
			i = new Intent(this,Settings2.class);
			startActivityForResult(i, Flaginator.chosen_mode);
			break;
		case R.id.btnScore:
			i = new Intent(this,Chart.class);
			startActivity(i);
			break;
		case R.id.btnInfo:
			i = new Intent(this,About.class);
			startActivity(i);
			break;
		case R.id.btnExit:
			finish();
			break;
		}
		

		/*switch (v.getId()) {
		case R.id.btnStart:
			new AlertDialog.Builder(this) 
				.setTitle(R.string.choose_continent_label)
				.setCancelable(false)
				.setItems(R.array.continent, 
						new DialogInterface.OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
								Intent intent;
								if (CHOSEN_MODE == 0) {
									intent = new Intent(getBaseContext(),StartCapital.class);
								}
						        else {
						        	intent = new Intent(getBaseContext(),StartFlag.class);
						        }
								intent.putExtra("continent", which);
								startActivity(intent);
								}
						})
						.show();
			break;
		case R.id.btnMode:
			i = new Intent(this,Settings.class);
			startActivityForResult(i, Flaginator.chosen_mode);
			break;
		case R.id.btnScore:
			i = new Intent(this,Chart.class);
			startActivity(i);
			break;
		case R.id.btnInfo:
			i = new Intent(this,About.class);
			startActivity(i);
			break;
		case R.id.btnExit:
			finish();
			break;
		}*/
	}
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
	  super.onActivityResult(requestCode, resultCode, data); 
	  switch(requestCode) { 
	    case chosen_mode :  
	      if (resultCode == Activity.RESULT_OK) { 
	      CHOSEN_MODE = data.getIntExtra("CHOSEN_VALUE", 0);
	      break; 
	    } 
	  } 
	}
}
