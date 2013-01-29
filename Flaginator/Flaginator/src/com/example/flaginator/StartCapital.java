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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;


public class StartCapital extends Activity implements OnClickListener {

	final String EuropeNames[] =	{"Andorra", "Albania", "Armenia", "Austria", "Azerbaijan", "Bosnia and Herzegovina", "Belgium", "Bulgaria", "Belarus", "Switzerland",
								  	 "Cyprus", "Czech Republic", "Germany", "Denmark", "Estonia", "Spain", "Finland", "France", "Georgia", "Greece",
								  	 "Croatia", "Hungary", "Ireland", "Iceland", "Italy", "Kazakhstan", "Liechtenstein", "Lithuania", "Luxembourg", "Latvia",
								  	 "Monaco", "Moldova", "Montenegro", "Macedonia", "Malta", "Netherlands", "Norway", "Poland", "Portugal", "Romania",
								  	 "Russia", "Sweden", "Slovenia", "Slovakia", "San Marino", "Serbia", "Turkey", "Ukraine", "United Kingdom", "Vatican City"};
	
	final String AsiaNames[] = 		{"Afghanistan", "Bahrain", "Bangladesh", "Bhutan", "Brunei", "Cambodia", "China", "India", "Indonesia", "Iran", 
									 "Iraq", "Israel", "Japan", "Jordan", "North Korea", "South Korea", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon",   
									 "Malaysia", "Maldives", "Mongolia", "Myanmar(Burma)", "Nepal", "Oman", "Pakistan", "Philippines", "Qatar", "Russia",
									 "Saudi Arabia", "Singapore", "Sri Lanka", "Syria", "Tajikistan", "Thailand", "East Timor", "Turkmenistan", "United Arab Emirates", "Uzbekistan", 
									 "Vietnam", "Yemen"};
	
	final String AfricaNames[] = 	{"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon", "Cape Verde", "Central Africa Republic", "Chad",   
								  	 "Comoros", "DR Congo", "Rebublic of the Congo", "Côte d'Ivoire", "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Ethiopia", "Gabon",
								  	 "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi",
								  	 "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Rwanda", "Sao Tomé and Príncipe",
								  	 "Senegal", "Seychelles", "Sierra Leone", "Somalia", "South Africa", "South Sudan", "Sudan", "Swaziland", "Tanzania", "Togo",
								  	 "Tunisia", "Uganda", "Zambia", "Zimbabwe"};
	
	final String AmericasNames[] = 	{"Antigua and Barbuda", "Argentina", "Bahamas", "Barbados", "Belize", "Bolivia", "Brazil", "Canada", "Chile", "Colombia", 
									 "Costa Rica", "Cuba", "Dominica", "Dominican Republic", "Ecuador", "El Salvador", "French Guiana","Grenada", "Guatemala", "Guyana",
									 "Haiti", "Honduras", "Jamaica", "Martinique", "Mexico", "Nicaragua", "Panama", "Paraguay", "Peru", "Puerto Rico", 
									 "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Suriname", "Trinidad and Tobago", "United States", "Uruguay", "Venezuela", "Virgin Islands"};
	
	final String EuropeCapital[] = 	{"Andorra la Vella", "Tirana", "Yerevan", "Vienna", "Baku", "Sarajevo", "Brussels", "Sofia", "Minsk", "Bern",
									 "Nicosia", "Prague", "Berlin", "Copenhagen", "Tallinn", "Madrid", "Helsinki", "Paris", "Tbilisi", "Athens",
									 "Zagreb", "Budapest", "Dublin", "Reykjavik", "Rome", "Astana", "Vaduz", "Vilnius", "Luxembourg", "Riga",
									 "Monaco", "Chisinau", "Podgorica", "Skopje", "Valletta", "Amsterdam", "Oslo", "Warsaw", "Lisbon", "Bucharest",
									 "Moscow", "Stockholm", "Ljubljana", "Bratislava", "San Marino", "Belgrade", "Ankara", "Kiev", "London", "Vatican City"};
	
	final String AsiaCapital[] = 	{"Kabul", "Manama", "Dhaka", "Thimphu", "Bandar Seri Begawan", "Phnom Penh", "Beijing", "New Delhi", "Jakarta", "Tehran",  
								  	 "Baghdad", "Jerusalem", "Tokyo", "Amman", "Pyongyang", "Seoul", "Kuwait City", "Bishkek", "Vientiane", "Beirut",    
								     "Kuala Lumpur", "Male", "Ulaanbaatar", "Nay Pyi Taw", "Kathmandu", "Muscat", "Islamabad", "Manila", "Doha", "Moscow",  
								     "Riyadh", "Singapore", "Colombo", "Damascus", "Dushanbe", "Bangkok", "Dili", "Ashgabat", "Abu Dhabi", "Tashkent", 
								     "Hanoi", "Sana'a"};
	
	final String AfricaCapital[] = 	{"Algiers", "Luanda", "Porto Novo", "Gaborone", "Ouagadougou", "Bujumbura", "Yaoundé", "Praia", "Bangui", "N'Djamena",
								     "Moroni", "Kinshasa", "Brazzaville", "Yamoussoukro", "Djibouti", "Cairo", "Malabo", "Asmara", "Addis Ababa", "Libreville",
								     "Banjul", "Accra", "Conakry", "Bissau", "Nairobi", "Maseru", "Monrovia", "Tripoli", "Antananarivo", "Lilongwe",
								     "Bamako", "Nouakchott", "Port Louis", "Rabat", "Maputo", "Windhoek", "Niamey", "Abuja", "Kigali", "Sao Tomé",
								     "Dakar", "Victoria", "Freetown", "Mogadishu", "Cape Town", "Juba", "Khartoum", "Lobamda/Mbabane", "Dodoma", "Lomé",
								     "Tunis", "Kampala", "Lusaka", "Harare", "", "", "", "", "", ""};
	
	final String AmericasCapital[] ={"St. John's", "Buenos Aires", "Nassau", "Bridgetown", "Belmopan", "La Paz", "Brasília", "Ottawa", "Santiago", "Bogotá", 
								     "San José", "Havana", "Roseau", "Santo Domingo", "Quito", "San Salvador", "Cayenne", "St. George's", "Guatemala City", "Georgetown", 
									 "Port-au-Prince", "Tegucigalpa", "Kingston", "Fort-de-France", "Mexico City", "Managua", "Panama City", "Asunción", "Lima", "San Juan",
									 "Basseterre", "Castries", "Kingstown", "Paramaribo", "Port of Spain", "Washington, D.C.", "Montevideo", "Caracas", "Road Town"};
	
	public static final String PREF_NAME = "MySettingsFile";						   
	
	int count = 10;
	int i = 0, j = 0;
	String[] countries;
	String[] capital;
	List<Integer> l_indexes;
	int[][] correct = new int[10][2];
	int[][] results = new int[10][2];
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_capital);
        
        View nextView = this.findViewById(R.id.button_next);
        nextView.setOnClickListener(this);
        
        View nextImgView = this.findViewById(R.id.next_image);
        nextImgView.setOnClickListener(this);
        
        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        count = settings.getInt("count", 10);
        
        correct = new int[count][2];
        results = new int[count][2];
        
        /*RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.d("Selected","New radio item selected: " + checkedId);
			}
		});*/
        
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
			countries = EuropeNames;
			capital = EuropeCapital;
			break;
		case 1:
			countries = AsiaNames;
			capital = AsiaCapital;
			break;
		case 2:
			countries = AfricaNames;
			capital = AfricaCapital;
			break;
		case 3:
			countries = AmericasNames;
			capital = AmericasCapital;
			break;
		default:
			break;
		}
        

        l_indexes = generate_countries_indexes(countries, count);
        set_rand_country(countries, l_indexes);
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
    
    public void set_rand_country(String[] countries, List<Integer> l_indexes) {
    	
    	int[] options_array = null;
    	j++;
    	
    	try {
	    	options_array = generate_options(countries, l_indexes.get(j-1));
	    	
	    	TextView tw = (TextView) findViewById(R.id.test_country);
	    	tw.setText(countries[l_indexes.get(j-1)].toString());
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
			radioButton1.setText(capital[l_indexes.get(j-1)]);
	        radioButton2.setText(capital[options_array[0]]);
	        radioButton3.setText(capital[options_array[1]]);
	        radioButton4.setText(capital[options_array[2]]);
	        break;
		case 1:
			radioButton1.setText(capital[options_array[0]]);
	        radioButton2.setText(capital[l_indexes.get(j-1)]);
	        radioButton3.setText(capital[options_array[1]]);
	        radioButton4.setText(capital[options_array[2]]); 
			break;
		case 2:
			radioButton1.setText(capital[options_array[0]]);
	        radioButton2.setText(capital[options_array[1]]);
	        radioButton3.setText(capital[l_indexes.get(j-1)]);
	        radioButton4.setText(capital[options_array[2]]);
			break;
		case 3:
			radioButton1.setText(capital[options_array[0]]);
	        radioButton2.setText(capital[options_array[1]]);
	        radioButton3.setText(capital[options_array[2]]);
	        radioButton4.setText(capital[l_indexes.get(j-1)]);
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
    
    public List<Integer> generate_countries_indexes(String[] countries, int count) {
    	Random rand = new Random();
    	
    	List<Integer> generated = new ArrayList<Integer>();
    	
    	for (int i = 0; i < count; i++) {
			while(true) {
				Integer next = rand.nextInt(countries.length-1) + 1;
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
    
    public int[] generate_options(String[] countries, int country_index) {
    	final Random rand = new Random();
    	int[] pos = new int[3];
    	
    	pos[0] = rand.nextInt(countries.length-1);
    	while (pos[0] == country_index) {
    		pos[0] = rand.nextInt(countries.length-1);
		}
    	
    	pos[1] = rand.nextInt(countries.length-1);
    	
    	while (pos[1] == pos[0] || (pos[1] == country_index)) {
    		pos[1] = rand.nextInt(countries.length-1);
		}
    	
    	pos[2] = rand.nextInt(countries.length-1);
    	
    	while ((pos[2] == pos[1]) || (pos[2] == pos[0]) || (pos[2] == country_index)) {
    		pos[2] = rand.nextInt(countries.length-1);
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
			set_rand_country(countries, l_indexes);
			
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
		set_rand_country(countries, l_indexes);
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