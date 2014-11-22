package com.example.rockpaperscissor;

import java.util.ArrayList;

import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class PlayerChoice extends ActionBarActivity {
	public static final int result_speech_code = 1;
	ImageButton speech;
	static String player1Choice="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void player1SpeakInput(View v) {
    	speech = (ImageButton)findViewById(R.id.speakButtonS2);
    	
    	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
    	
    	try {
    		startActivityForResult(intent, result_speech_code);
    	}
    	catch (ActivityNotFoundException exc) {
    		Toast t = Toast.makeText(getApplicationContext(), "Your device does not support speech to text", Toast.LENGTH_SHORT);
    		t.show();
    	}
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	switch(requestCode) {
    		case result_speech_code: {
    			if(resultCode == RESULT_OK && null != data) {
    				ArrayList<String> textList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
    				player1Choice = textList.get(0);
    				if (player1Choice.equals("rock") || player1Choice.equals("Rock") || player1Choice.equals("fuck") ||
    						player1Choice.equals("paper") || player1Choice.equals("Paper") || player1Choice.equals("scissors") || 
    						player1Choice.equals("scissor") || player1Choice.equals("seether") || player1Choice.equals("cearsers") || 
    						player1Choice.equals("ceaser")) {
    					Intent i = new Intent(PlayerChoice.this, PlayerChoiceDisplay.class);
    					startActivity(i);
    				}
    				else {
    					Toast t = Toast.makeText(getApplicationContext(), "Did not catch that clearly! Please speak again!", Toast.LENGTH_SHORT);
    		    		t.show();
    				}
    					
    			}
    			break;
    		}
    	}
    }
}