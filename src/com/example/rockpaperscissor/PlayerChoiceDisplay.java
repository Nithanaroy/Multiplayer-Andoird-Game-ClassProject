package com.example.rockpaperscissor;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class PlayerChoiceDisplay extends ActionBarActivity {

	static String playerChoiceS3 = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		TextView choice = (TextView) findViewById(R.id.p1_choice_text);
		playerChoiceS3 = PlayerChoice.player1Choice.toString();
		if (playerChoiceS3.equals("rock") || playerChoiceS3.equals("Rock") || playerChoiceS3.equals("fuck")) {
			choice.setText("Rock!");
		} else if (playerChoiceS3.equals("paper") || playerChoiceS3.equals("Paper") || playerChoiceS3.equals("beeper") || playerChoiceS3.equals("papers")) {
			choice.setText("Paper!");
		} else if (playerChoiceS3.equals("scissors") || playerChoiceS3.equals("Scissors") || playerChoiceS3.equals("ceasers") || playerChoiceS3.equals("seether") || playerChoiceS3.equals("scissor")) {
			choice.setText("Scissors!");
		}
	}

	private void sendChoiceToOtherPlayer(String choice) {
		byte[] send = choice.getBytes();
		MyApplication.mChatService.write(send);
	}

	public void goToSecondActivity(View v) {
		Intent i = new Intent(PlayerChoiceDisplay.this, PlayerChoice.class);
		startActivity(i);
	}

	public void goToFourthActivity(View v) {
		if (!MyApplication.isSinglePlayer) {
			sendChoiceToOtherPlayer(playerChoiceS3);
		}
		Intent i = new Intent(PlayerChoiceDisplay.this, GameResult.class);
		startActivity(i);
	}
}
