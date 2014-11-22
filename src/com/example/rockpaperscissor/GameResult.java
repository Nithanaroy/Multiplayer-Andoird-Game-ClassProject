package com.example.rockpaperscissor;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameResult extends ActionBarActivity {
	static int win, loss;
	static int num;
	static String cpu_choice;
	static String player_choice = "";
	static String player_choice_number;
	TextView cpu_select;
	TextView winner;
	TextView player_select;
	Button records;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourth);

		MyApplication.gameResult = this;

		winner = (TextView) findViewById(R.id.winnerName_Text);
		records = (Button) findViewById(R.id.record_Button);

		TextView player2Header = (TextView) findViewById(R.id.comp_selected);
		if (MyApplication.isSinglePlayer) {
			player2Header.setText(R.string.cpu_selected_text);
		} else
			player2Header.setText(R.string.friend_selected_text);

		cpu_select = (TextView) findViewById(R.id.cpu_selection_text);

		getPlayerChoice();
		if (MyApplication.isSinglePlayer == true) {
			decideSinglePlayerWinner();
		} else {
			Button records = (Button) findViewById(R.id.record_Button);
			records.setEnabled(false);
			winner.setText("Waiting for your friend's choice...");
			decideMultiPlayerWinner();
		}
	}


	public void decideMultiPlayerWinner() {
		if (MyApplication.inComingMessage != null) {
			String player2Choice = decodePlayerChoice(MyApplication.inComingMessage);
			codeToWord(Integer.parseInt(player2Choice));
			computeWinner(player_choice_number, player2Choice);
			records.setEnabled(true);
			MyApplication.inComingMessage = null;
		}
	}


	private void decideSinglePlayerWinner() {
		getComputerChoice();
		computeWinner(player_choice_number, cpu_choice);
	}


	private String getComputerChoice() {
		Random r = new Random();
		num = r.nextInt(10 - 1) + 1;
		return codeToWord(num);
	}


	private String codeToWord(int num) {
		if (num == 1 || num == 4 || num == 7) {
			cpu_choice = "" + 1;
			cpu_select.setText("ROCK!!");
		} else if (num == 2 || num == 5 || num == 8) {
			cpu_choice = "" + 2;
			cpu_select.setText("PAPER!!");
		} else if (num == 3 || num == 6 || num == 9) {
			cpu_choice = "" + 3;
			cpu_select.setText("SCISSORS!!");
		}
		return cpu_choice;
	}


	private String getPlayerChoice() {
		player_choice = PlayerChoiceDisplay.playerChoiceS3.toString();
		player_select = (TextView) findViewById(R.id.player_selected_ans);
		player_choice_number = decodePlayerChoice(player_choice);
		if (player_choice_number.equals("1")) {
			player_select.setText("ROCK!!");
		} else if (player_choice_number.equals("2")) {
			player_select.setText("PAPER!!");
		} else if (player_choice_number.equals("3")) {
			player_select.setText("SCISSORS!!");
		}
		return player_choice_number;
	}

	private String decodePlayerChoice(String choiceKey) {
		String choiceValue = null;
		if (choiceKey.equals("rock") || choiceKey.equals("Rock") || choiceKey.equals("fuck")) {
			choiceValue = "1";
		} else if (choiceKey.equals("paper") || choiceKey.equals("Paper") || choiceKey.equals("beeper") || choiceKey.equals("papers")) {
			choiceValue = "2";
		} else if (choiceKey.equals("scissors") || choiceKey.equals("scissors") || choiceKey.equals("Scissors") || choiceKey.equals("ceasers") || choiceKey.equals("seether")
				|| choiceKey.equals("scissor")) {
			choiceValue = "3";
		}
		return choiceValue;
	}


	private void computeWinner(String player_choice_number, String cpu_choice) {

		String player2 = MyApplication.isSinglePlayer ? "Computer" : "Your Friend";

		if (player_choice_number.equals("1") && cpu_choice.equals("2")) {
			winner.setText(player2);
			loss = 1;
			win = 0;
		} else if (player_choice_number.equals("1") && cpu_choice.equals("3")) {
			winner.setText("You");
			loss = 0;
			win = 1;
		} else if (player_choice_number.equals("2") && cpu_choice.equals("1")) {
			winner.setText("You");
			loss = 0;
			win = 1;
		} else if (player_choice_number.equals("2") && cpu_choice.equals("3")) {
			winner.setText(player2);
			loss = 1;
			win = 0;
		} else if (player_choice_number.equals("3") && cpu_choice.equals("1")) {
			winner.setText(player2);
			loss = 1;
			win = 0;
		} else if (player_choice_number.equals("3") && cpu_choice.equals("2")) {
			winner.setText("You");
			loss = 0;
			win = 1;
		} else if (player_choice_number.equals("3") && cpu_choice.equals("3")) {
			winner.setText("Its a TIE! No Result!");
			loss = 0;
			win = 0;
		} else if (player_choice_number.equals("2") && cpu_choice.equals("2")) {
			winner.setText("Its a TIE! No Result!");
			loss = 0;
			win = 0;
		} else if (player_choice_number.equals("1") && cpu_choice.equals("1")) {
			winner.setText("Its a TIE! No Result!");
			loss = 0;
			win = 0;
		}
	}


	public void nextActivity(View v) {

		Intent i = new Intent(GameResult.this, PlayerStatistics.class);
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
