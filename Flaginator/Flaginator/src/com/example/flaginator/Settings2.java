package com.example.flaginator;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class Settings2 extends Activity implements OnSeekBarChangeListener, OnClickListener {

	static final String[] MODES = new String[] {"Guess Capital", "Guess Flag"};
	public static final String PREF_NAME = "MySettingsFile";
	
	SeekBar mSeekBar;
	TextView mProgressText;
	TextView mTrackingText;
	int i_mode = 0;
	int count = 10;
	boolean toggle = false;
	
	private ListView lv;
	private ArrayAdapter<String> adapter;
	
	@SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        i_mode = settings.getInt("mode", 0);
        count = settings.getInt("count", 10);
        toggle = settings.getBoolean("toggle", false);
        
        
        View btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        //ToggleButton tg = (ToggleButton) findViewById(R.id.toggle);
        //tg.setOnClickListener(this);
        //View btnSetDefault = (Button) findViewById(R.id.btnSetDefault);
        //btnSetDefault.setOnClickListener(this);
        
        lv = (ListView) findViewById(R.id.list);
        
        lv.setOnItemClickListener(new OnItemClickListener() {   
        	public void onItemClick(AdapterView arg0, View arg1, int positon, long arg3) {    
        		switch (positon) {    
        		case 0:     
        			i_mode = 0;  
        			break;    
        		case 1:     
        			i_mode = 1;     
        			break;    
        		default:     
        			i_mode = 0;
        			break;
        			}    
        		
        	}
        });
        
        
        ArrayList<String> modesList = new ArrayList<String>();
        modesList.addAll(Arrays.asList(MODES));
        
        adapter = new ArrayAdapter<String>(this, R.layout.activity_settings_item_row, modesList);
        
        lv.setAdapter(adapter);
        lv.setChoiceMode(lv.CHOICE_MODE_SINGLE);
        lv.setItemChecked(i_mode, true);
        //lv.setBackgroundResource(R.drawable.rounded_corner_shape_listview);
        
        mSeekBar = (SeekBar) findViewById(R.id.seek);
        mSeekBar.setProgress(count);
        mSeekBar.setOnSeekBarChangeListener(this);
        mProgressText = (TextView) findViewById(R.id.progress);
        //mProgressText.setText("Countries to be shown: " + mSeekBar.getProgress());
        mProgressText.setText("Countries to be shown: " + count);
        
        //tg.setChecked(toggle);
	}
	
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
        mProgressText.setText("Countries to be shown: " + progress);
        count = progress;
    }
 
    public void onStartTrackingTouch(SeekBar seekBar) {
        //mTrackingText.setText("Tracking on");
    }
 
    public void onStopTrackingTouch(SeekBar seekBar) {
        //mTrackingText.setText("Tracking off");
    }
    
    public void OnSeekBarChangeListener(SeekBar seekbar){
    	
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_settings, menu);
        return true;
    }
    
	public void onListItemClick(ListView l, View v, int position, long id) {
    	
    	l.setItemChecked(position, true);
    	
    	Intent resultIntent = new Intent();		
        resultIntent.putExtra("CHOSEN_VALUE", position);
    	setResult(Activity.RESULT_OK,resultIntent);
    	finish();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSave:
			SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putInt("count", count);
			editor.putInt("mode", i_mode);
			editor.putBoolean("toggle", toggle);
			editor.commit();
			finish();
			break;
		//case R.id.btnSetDefault:
		//	mSeekBar.setProgress(10);
		//	break;
		}
	}
}