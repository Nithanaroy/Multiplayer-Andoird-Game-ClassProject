package com.example.rockpaperscissor;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity {
	public String radioText;
	static String uname,ag,sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onRadioClicked (View v) {
    	boolean checked = ((RadioButton) v).isChecked();
    	
    	switch (v.getId()) {
    	case R.id.RB_male:
    		if (checked) {
    			radioText = "Male";
    			break;
    		}
    	case R.id.RB_female:
    		if (checked) {
    			radioText = "Female";
    			break;
    		}	
    	}
    }
    
    public void startGamePlay (View v) {
    	try
    	{
	    	DBhandler dbh = new DBhandler(this, null, null, 1);
	    	System.out.println("CHECK 1");
	    	
	    	
	    	
	    	System.out.println("CHECK 4");
	    	EditText name = (EditText)findViewById(R.id.name_Box_S1);
	    	System.out.println("CHECK 5");
	    	EditText age = (EditText)findViewById(R.id.age_Box_S1);
	    	
	    	uname=name.getText().toString();
	    	ag=age.getText().toString();
	    	sex=radioText;
	    	
	    	// CHECK WHETHER THE USER IS ALREADY PRESENT AND IF HE/SHE IS, GET AND UPDATE RESULTS HERE.
	    	// WRITE THE CODE FOR THAT.
	    	
	    	
	    	System.out.println("Name "+uname);
	    	System.out.println("Age "+ag);
	    	System.out.println("Sex "+sex);
	    	
	    	if(uname == "")
	    	{
	    		name.setText("problem");
	    	}
	    	else
	    	{
	    	
		    	directory d = new directory(uname,ag,sex,0,0);
		 	   	
		    	dbh.addUser(d);
		 	   	name.setText("");
		    	age.setText("");
		    	
		    	System.out.println("Start of 2nd Activity");
		    	Intent i = new Intent (MainActivity.this, SecondActivity.class);
		    	startActivity(i);
	    	}
    	}catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
