package com.example.rockpaperscissor;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FourthActivity extends ActionBarActivity {
	static int win,loss;
	static int num;
	static String cpu_choice;
	static String player_choice="";
	static String player_choice_number;
	TextView cpu_select;
	TextView winner;
	TextView player_select;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourth);
		
		cpu_select = (TextView)findViewById(R.id.cpu_selection_text);
		Random r = new Random();
		num = r.nextInt(10-1)+1;
		if (num==1 || num==2 || num==3) {
			cpu_choice =""+ 1;
			cpu_select.setText("ROCK!!"+cpu_choice);
		}
		else if (num==4 || num==5 || num==6) {
			cpu_choice =""+ 2;
			cpu_select.setText("PAPER!!"+cpu_choice);
		}
		else if (num==7 || num==8 || num==9) {
			cpu_choice = ""+3;
			cpu_select.setText("SCISSORS!!"+cpu_choice);
		}
		
		player_choice = ThirdActivity.playerChoiceS3.toString();
		player_select = (TextView)findViewById(R.id.player_selected_ans);
		if (player_choice.equals("rock")) {
			player_choice_number = ""+1;
		}
		if (player_choice.equals("paper")) {
			player_choice_number = ""+2;
		}
		if (player_choice.equals("scissors")) {
			player_choice_number = ""+3;
		}
		player_select.setText(player_choice+" : "+player_choice_number);
		
		winner = (TextView)findViewById(R.id.winnerName_Text);
		if(player_choice_number.equals("1") && cpu_choice.equals("2")) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		else if(player_choice_number.equals("1") && cpu_choice.equals("3")) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		else if(player_choice_number.equals("2") && cpu_choice.equals("1")) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		else if(player_choice_number.equals("2") && cpu_choice.equals("3")) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		else if(player_choice_number.equals("3") && cpu_choice.equals("1")) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		else if(player_choice_number.equals("3") && cpu_choice.equals("2")) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		else if(player_choice_number.equals("3") && cpu_choice.equals("3")) {
			winner.setText("Its a TIE! No Result!");
			loss=0;
			win=0; 
		}
		else if(player_choice_number.equals("2") && cpu_choice.equals("2")) {
			winner.setText("Its a TIE! No Result!");
			loss=0;
			win=0; 
		}
		else if(player_choice_number.equals("1") && cpu_choice.equals("1")) {
			winner.setText("Its a TIE! No Result!");
			loss=0;
			win=0; 
		}
	}
	
	/*
	public void decideWinner() {
		winner = (TextView)findViewById(R.id.winnerName_Text);
		if(player_choice_number == 1 && cpu_choice == 2) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		if(player_choice_number == 1 && cpu_choice == 3) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		if(player_choice_number == 2 && cpu_choice == 1) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		if(player_choice_number == 2 && cpu_choice == 3) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		if(player_choice_number == 3 && cpu_choice == 1) {
			winner.setText("Computer");
			loss=1;
			win=0;
		}
		if(player_choice_number == 3 && cpu_choice == 2) {
			winner.setText("Player 1");
			loss=0;
			win=1;
		}
		else {
			winner.setText("Its a TIE! No Result!");
			loss=0;
			win=0; 
		}
	}
	*/
	
	public void nextActivity (View v) {
		
		Intent i = new Intent(FourthActivity.this, FifthActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fourth, menu);
		return true;
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
}
