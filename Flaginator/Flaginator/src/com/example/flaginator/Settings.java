package com.example.flaginator;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;

public class Settings extends ListActivity {

    static final String[] MODES = new String[] {"Guess Capital", "Guess Flag"};
	
	@SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, MODES);
        setListAdapter(adapter);
        
        ListView lv = getListView();
        lv.setChoiceMode(lv.CHOICE_MODE_SINGLE);
        lv.setItemChecked(0, true);
  
        //AK POUZIJEM activity_settings layout (moemntalne pouzivam defaultny andorid layput "simple_list_item_1")
        
        /*setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_settings, MODES));
        
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setBackgroundColor(getResources().getColor(R.color.main_background));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
			    Intent resultIntent = new Intent();
			    resultIntent.putExtra("CHOSEN_VALUE", position);
			    setResult(Activity.RESULT_OK,resultIntent);
			    finish();
			}
		});*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_settings, menu);
        return true;
    }
    
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	
    	l.setItemChecked(position, true);
    	
    	Intent resultIntent = new Intent();
        resultIntent.putExtra("CHOSEN_VALUE", position);
    	setResult(Activity.RESULT_OK,resultIntent);
    	finish();
	}
}
