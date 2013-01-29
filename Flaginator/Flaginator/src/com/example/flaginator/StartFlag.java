package com.example.flaginator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;

public class StartFlag extends Activity implements OnClickListener {

	final int flagsEurope[] = {R.drawable.ad, R.drawable.al, R.drawable.am, R.drawable.at, R.drawable.az,R.drawable.ba, R.drawable.be, R.drawable.bg, R.drawable.by, R.drawable.ch,
							   R.drawable.cy, R.drawable.cz, R.drawable.de, R.drawable.dk, R.drawable.ee,R.drawable.es, R.drawable.fi, R.drawable.fr, R.drawable.ge, R.drawable.gr,
							   R.drawable.hr, R.drawable.hu, R.drawable.ie, R.drawable.is, R.drawable.it,R.drawable.kz, R.drawable.li, R.drawable.lt, R.drawable.lu, R.drawable.lv,
							   R.drawable.mc, R.drawable.md, R.drawable.me, R.drawable.mm, R.drawable.mt,R.drawable.nl, R.drawable.no, R.drawable.pl, R.drawable.pt, R.drawable.ro,
							   R.drawable.ru, R.drawable.se, R.drawable.si, R.drawable.sk, R.drawable.sm,R.drawable.ss, R.drawable.tr, R.drawable.ua, R.drawable.uk, R.drawable.vh};
	
	final int flagsAsia[] =   {R.drawable.af, R.drawable.bh, R.drawable.bd, R.drawable.bt, R.drawable.bn,R.drawable.cb, R.drawable.cn, R.drawable.in, R.drawable.id, R.drawable.ir,
							   R.drawable.iq, R.drawable.il, R.drawable.jp, R.drawable.jo, R.drawable.kp,R.drawable.kr, R.drawable.kw, R.drawable.kg, R.drawable.la, R.drawable.lb,
							   R.drawable.my, R.drawable.mv, R.drawable.mn, R.drawable.bu, R.drawable.np,R.drawable.om, R.drawable.pk, R.drawable.ph, R.drawable.qa, R.drawable.ru,
							   R.drawable.sa, R.drawable.sg, R.drawable.sp, R.drawable.sy, R.drawable.tj,R.drawable.th, R.drawable.tl, R.drawable.tm, R.drawable.ua, R.drawable.uz,
							   R.drawable.vn, R.drawable.ye};
	
	final int flagsAfrica[] = {R.drawable.dz, R.drawable.ao, R.drawable.bj, R.drawable.bw, R.drawable.bf,R.drawable.bi, R.drawable.cm, R.drawable.cv, R.drawable.cf, R.drawable.ce,
							   R.drawable.cj, R.drawable.cd, R.drawable.cg, R.drawable.ci, R.drawable.dj,R.drawable.eg, R.drawable.gq, R.drawable.er, R.drawable.et, R.drawable.ga,
							   R.drawable.gm, R.drawable.gh, R.drawable.gn, R.drawable.gw, R.drawable.ke,R.drawable.ls, R.drawable.lr, R.drawable.ld, R.drawable.mg, R.drawable.mw,
							   R.drawable.ml, R.drawable.mr, R.drawable.mu, R.drawable.ma, R.drawable.mz,R.drawable.na, R.drawable.ne, R.drawable.ng, R.drawable.rw, R.drawable.st,
							   R.drawable.sn, R.drawable.sc, R.drawable.sl, R.drawable.so, R.drawable.za,R.drawable.su, R.drawable.sd, R.drawable.sw, R.drawable.tz, R.drawable.tg,
							   R.drawable.tn, R.drawable.ug, R.drawable.zm, R.drawable.zw};
	
	final int flagsAmericas[] = {R.drawable.ag, R.drawable.ar, R.drawable.bs, R.drawable.bb, R.drawable.bl,R.drawable.bo, R.drawable.br, R.drawable.ca, R.drawable.cu, R.drawable.co,
							     R.drawable.cr, R.drawable.cu, R.drawable.dm, R.drawable.dz ,R.drawable.ec,R.drawable.sv, R.drawable.fg, R.drawable.gd, R.drawable.gt, R.drawable.gy,
							     R.drawable.ht, R.drawable.hn, R.drawable.jm, R.drawable.mq, R.drawable.mx,R.drawable.ni, R.drawable.pa, R.drawable.py, R.drawable.pe, R.drawable.pr,
							     R.drawable.sz, R.drawable.sj, R.drawable.vc, R.drawable.sr, R.drawable.tt,R.drawable.us, R.drawable.uy, R.drawable.ve, R.drawable.vi};
	
	final String flagsEuropeNames[] =	{"Andorra", "Albania", "Armenia", "Austria", "Azerbaijan", "Bosnia and Herzegovina", "Belgium", "Bulgaria", "Belarus", "Switzerland",
								         "Cyprus", "Czech Republic", "Germany", "Denmark", "Estonia", "Spain", "Finland", "France", "Georgia", "Greece",
								         "Croatia", "Hungary", "Ireland", "Iceland", "Italy", "Kazakhstan", "Liechtenstein", "Lithuania", "Luxembourg", "Latvia",
								         "Monaco", "Moldova", "Montenegro", "Macedonia", "Malta", "Netherlands", "Norway", "Poland", "Portugal", "Romania",
								         "Russia", "Sweden", "Slovenia", "Slovakia", "San Marino", "Serbia", "Turkey", "Ukraine", "United Kingdom", "Vatican City"};
	
	final String flagsAsiaNames[] = 	{"Afghanistan", "Bahrain", "Bangladesh", "Bhutan", "Brunei", "Cambodia", "China", "India", "Indonesia", "Iran", 
										 "Iraq", "Israel", "Japan", "Jordan", "North Korea", "South Korea", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon",   
										 "Malaysia", "Maldives", "Mongolia", "Myanmar(Burma)", "Nepal", "Oman", "Pakistan", "Philippines", "Qatar", "Russia",
										 "Saudi Arabia", "Singapore", "Sri Lanka", "Syria", "Tajikistan", "Thailand", "East Timor", "Turkmenistan", "United Arab Emirates", "Uzbekistan", 
										 "Vietnam", "Yemen"};
	
	final String flagsAfricaNames[] = 	{"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon", "Cape Verde", "Central Africa Republic", "Chad",   
									     "Comoros", "DR Congo", "Rebublic of the Congo", "Côte d'Ivoire", "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Ethiopia", "Gabon",
									     "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi",
									     "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Rwanda", "Sao Tomé and Príncipe",
									     "Senegal", "Seychelles", "Sierra Leone", "Somalia", "South Africa", "South Sudan", "Sudan", "Swaziland", "Tanzania", "Togo",
									     "Tunisia", "Uganda", "Zambia", "Zimbabwe"};

	final String flagsAmericasNames[] = {"Antigua and Barbuda", "Argentina", "Bahamas", "Barbados", "Belize", "Bolivia", "Brazil", "Canada", "Chile", "Colombia", 
										 "Costa Rica", "Cuba", "Dominica", "Dominican Republic", "Ecuador", "El Salvador", "French Guiana","Grenada", "Guatemala", "Guyana",
										 "Haiti", "Honduras", "Jamaica", "Martinique", "Mexico", "Nicaragua", "Panama", "Paraguay", "Peru", "Puerto Rico", 
										 "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Suriname", "Trinidad and Tobago", "United States", "Uruguay", "Venezuela", "Virgin Islands"};
	
	public static final String PREF_NAME = "MySettingsFile";						   
	
	int count = 10;
	int i = 0, j = 0;
	int[] flags;
	String[] flagsNames;
	List<Integer> l_indexes;
	int[][] correct = new int[10][2];
	int[][] results = new int[10][2];
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_flag);
        
        View nextView = this.findViewById(R.id.button_next);
        nextView.setOnClickListener(this);
        
        View nextImgView = this.findViewById(R.id.next_image);
        nextImgView.setOnClickListener(this);
        
        /*RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.d("Selected","New radio item selected: " + checkedId);
			}
		});*/
        
        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        count = settings.getInt("count", 10);
        
        correct = new int[count][2];
        results = new int[count][2];
        
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.setOnClickListener(myGroupListener);
        
        RadioButton myOption1 = (RadioButton)findViewById(R.id.option1);
        RadioButton myOption2 = (RadioButton)findViewById(R.id.option2);
        RadioButton myOption3 = (RadioButton)findViewById(R.id.option3);
        RadioButton myOption4 = (RadioButton)findViewById(R.id.option4);
        
        myOption1.setOnClickListener(myRadioListener);
        myOption2.setOnClickListener(myRadioListener);
        myOption3.setOnClickListener(myRadioListener);
        myOption4.setOnClickListener(myRadioListener);
        
        Bundle extras = getIntent().getExtras();
        int continent_id = 0;
        
        if (extras != null) {
			continent_id = extras.getInt("continent",0);
		}
        
        switch (continent_id) {
		case 0:
			flags = flagsEurope;
			flagsNames = flagsEuropeNames;
			break;
		case 1:
			flags = flagsAsia;
			flagsNames = flagsAsiaNames;
			break;
		case 2:
			flags = flagsAfrica;
			flagsNames = flagsAfricaNames;
			break;
		case 3:
			flags = flagsAmericas;
			flagsNames = flagsAmericasNames;
			break;
		default:
			break;
		}
        

        l_indexes = generate_flags_indexes(flags, count);
        set_rand_pic(flags, l_indexes);
    }

OnClickListener myRadioListener = new OnClickListener() {
		
		public void onClick(View v) {	
			
			int id = v.getId();
			int result = -1;
			int number = -1;
			int position = 0;   
			
			RadioButton rb = (RadioButton) findViewById(v.getId());
			TextView tw = (TextView) findViewById(R.id.number_label);
			
			position = tw.getText().toString().indexOf(".");   
			
			try{
				number = Integer.parseInt(tw.getText().toString().substring(0, position) );
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Could not parse " + nfe);
			}
			
			switch (id) {
			case R.id.option1:
				result = 0; 
				break;
			case R.id.option2:
				result = 1; 
				break;
			case R.id.option3:
				result = 2; 
				break;
			case R.id.option4:
				result = 3; 
				break;
			default:
				result = -1;
				break;
			}
			
			switch (correct[number-1][1]) {
			case 0:
				RadioButton myCorrectOption = (RadioButton)findViewById(R.id.option1);
				myCorrectOption.setTextColor(getResources().getColor(R.color.green));
				break;
			case 1:
				myCorrectOption = (RadioButton)findViewById(R.id.option2);
				myCorrectOption.setTextColor(getResources().getColor(R.color.green));
				break;
			case 2:
				myCorrectOption = (RadioButton)findViewById(R.id.option3);
				myCorrectOption.setTextColor(getResources().getColor(R.color.green));
				break;
			case 3:
				myCorrectOption = (RadioButton)findViewById(R.id.option4);
				myCorrectOption.setTextColor(getResources().getColor(R.color.green));
				break;
			default:
				break;
			}
			
			if (result == correct[number-1][1]) {
				rb.setTextColor(getResources().getColor(R.color.green));
			}
			else
			{
				rb.setTextColor(getResources().getColor(R.color.red));
			}
			
			
			rb.setEnabled(false);
			
			
			RadioButton myOption1 = (RadioButton)findViewById(R.id.option1);
	        RadioButton myOption2 = (RadioButton)findViewById(R.id.option2);
	        RadioButton myOption3 = (RadioButton)findViewById(R.id.option3);
	        RadioButton myOption4 = (RadioButton)findViewById(R.id.option4);
	        
			myOption1.setEnabled(false);
			myOption2.setEnabled(false);
			myOption3.setEnabled(false);
			myOption4.setEnabled(false);
			//onNext();
		}
	};
	
	//Toto tu musi byt inak aplikacia crashuje ak kliknes medzi radiobuttony do prazdneho priestoru.
		OnClickListener myGroupListener = new OnClickListener() {
			
			public void onClick(View v) {
				@SuppressWarnings("unused")
				int result = 0;
				result = 1;
			}
		};
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_start_flag, menu);
        return true;
    }
    
    
    public void set_rand_pic(int[] flags, List<Integer> l_indexes) {
    	
    	int[] options_array = null;
    	j++;
    	
    	try {
	    	options_array = generate_options(flags, l_indexes.get(j-1));
	    	
	    	ImageView img = (ImageView) findViewById(R.id.test_image);
	    	img.setImageResource(flags[l_indexes.get(j-1)]);
    	}
    	catch(ArrayIndexOutOfBoundsException e) {
    		Log.d("Exception!", "IndexOutOfRange");
    	}
    	
    	RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.clearCheck();
    	
    	RadioButton radioButton1 = (RadioButton) findViewById(R.id.option1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.option2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.option3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.option4);
        
        int pos = generate_random_int(4);
        
        correct[j-1][0] = j;
        correct[j-1][1] = pos;
        
        switch (pos) {
		case 0:
			radioButton1.setText(flagsNames[l_indexes.get(j-1)]);
	        radioButton2.setText(flagsNames[options_array[0]]);
	        radioButton3.setText(flagsNames[options_array[1]]);
	        radioButton4.setText(flagsNames[options_array[2]]);
	        break;
		case 1:
			radioButton1.setText(flagsNames[options_array[0]]);
	        radioButton2.setText(flagsNames[l_indexes.get(j-1)]);
	        radioButton3.setText(flagsNames[options_array[1]]);
	        radioButton4.setText(flagsNames[options_array[2]]); 
			break;
		case 2:
			radioButton1.setText(flagsNames[options_array[0]]);
	        radioButton2.setText(flagsNames[options_array[1]]);
	        radioButton3.setText(flagsNames[l_indexes.get(j-1)]);
	        radioButton4.setText(flagsNames[options_array[2]]);
			break;
		case 3:
			radioButton1.setText(flagsNames[options_array[0]]);
	        radioButton2.setText(flagsNames[options_array[1]]);
	        radioButton3.setText(flagsNames[options_array[2]]);
	        radioButton4.setText(flagsNames[l_indexes.get(j-1)]);
			break;
		default:
			break;
		}
    }
    
    public int generate_random_int(int count) {
    	final Random rand = new Random();
    	int pos = rand.nextInt(4);
    	return pos;
    }
    
    public List<Integer> generate_flags_indexes(int[] flags, int count) {
    	Random rand = new Random();
    	
    	List<Integer> generated = new ArrayList<Integer>();
    	
    	for (int i = 0; i < count; i++) {
			while(true) {
				Integer next = rand.nextInt(flags.length-1) + 1;
				if (!generated.contains(next)) {
					generated.add(next);
					break;
				}
			}
		}
    	
    	return generated;
    	
    	/*final Random rand = new Random();
    	int pos = rand.nextInt(flags.length-1);
    	return pos;*/
    }
    
    public int[] generate_options(int[] flags, int flag_index) {
    	final Random rand = new Random();
    	int[] pos = new int[3];
    	
    	pos[0] = rand.nextInt(flags.length-1);
    	while (pos[0] == flag_index) {
    		pos[0] = rand.nextInt(flags.length-1);
		}
    	
    	pos[1] = rand.nextInt(flags.length-1);
    	
    	while (pos[1] == pos[0] || (pos[1] == flag_index)) {
    		pos[1] = rand.nextInt(flags.length-1);
		}
    	
    	pos[2] = rand.nextInt(flags.length-1);
    	
    	while ((pos[2] == pos[1]) || (pos[2] == pos[0]) || (pos[2] == flag_index)) {
    		pos[2] = rand.nextInt(flags.length-1);
		}
		
    	return pos;
    }
    
    public int evaluate_part(int[][] correct, int[][] results) {
    	int correct_count = 0;
    	for (int i = 0; i < results.length; i++) {
			if (results[i][1] == correct[i][1]) {
				Log.d("BLA", String.valueOf(results[i][1]) + ", " + String.valueOf(correct[i][1]));
				correct_count ++;
			}
		}
    	return correct_count;
    }

public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.button_next:
		case R.id.next_image:
			i++;
			
			TextView number_label = (TextView) findViewById(R.id.number_label);
			RadioGroup rg = (RadioGroup) findViewById(R.id.group);
			int id = rg.getCheckedRadioButtonId();
			
			results[i-1][0] = i;
			
			switch (id) {
			case R.id.option1:
				results[i-1][1] = 0; 
				break;
			case R.id.option2:
				results[i-1][1] = 1; 
				break;
			case R.id.option3:
				results[i-1][1] = 2; 
				break;
			case R.id.option4:
				results[i-1][1] = 3; 
				break;
			default:
				results[i-1][1] = -1;
				break;
			}
			
			if (i == count-1) {
				Button nextViewButton = (Button) findViewById(R.id.button_next);
				nextViewButton.setText("DONE");
		    }
			else {
				if (i == count) {
					int res = evaluate_part(correct, results);
					openResultsDialog(res,count-res);
					break;
					}
			}
			number_label.setText((i+1) + ".");
			set_rand_pic(flags, l_indexes);
			
			RadioButton myOption1 = (RadioButton) findViewById(R.id.option1);
			RadioButton myOption2 = (RadioButton) findViewById(R.id.option2);
			RadioButton myOption3 = (RadioButton) findViewById(R.id.option3);
			RadioButton myOption4 = (RadioButton) findViewById(R.id.option4);
			
			myOption1.setTextColor(getResources().getColor(R.color.white));
			myOption2.setTextColor(getResources().getColor(R.color.white));
			myOption3.setTextColor(getResources().getColor(R.color.white));
			myOption4.setTextColor(getResources().getColor(R.color.white));
			
			myOption1.setEnabled(true);
			myOption2.setEnabled(true);
			myOption3.setEnabled(true);
			myOption4.setEnabled(true);
			
		    break;
		}
	}
	
	/*public void onNext()
	{
		i++;
		
		TextView number_label = (TextView) findViewById(R.id.number_label);
		RadioGroup rg = (RadioGroup) findViewById(R.id.group);
		int id = rg.getCheckedRadioButtonId();
		
		results[i-1][0] = i;
		
		switch (id) {
		case R.id.option1:
			results[i-1][1] = 0; 
			break;
		case R.id.option2:
			results[i-1][1] = 1; 
			break;
		case R.id.option3:
			results[i-1][1] = 2; 
			break;
		case R.id.option4:
			results[i-1][1] = 3; 
			break;
		default:
			results[i-1][1] = -1;
			break;
		}
	
		if (i == 10) 
		{
			int res = evaluate_part(correct, results);
			openResultsDialog(res,10-res);
			return;
		}
		number_label.setText((i+1) + ".");
		set_rand_pic(flags, l_indexes);
	}*/
	
	private void openResultsDialog(int correct, int wrong) {
		new AlertDialog.Builder(this)
			.setTitle("Results")
			.setMessage("CORRECT:\t" + correct + "\nWRONG:\t\t" + wrong)
			.setCancelable(false)
			.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				})
			.show();	
	}
}
