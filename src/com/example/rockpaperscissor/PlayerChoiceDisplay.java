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

		if (!AppVariables.isSinglePlayer) {
			sendChoiceToOtherPlayer(playerChoiceS3);
		}
	}

	private void sendChoiceToOtherPlayer(String choice) {
		byte[] send = choice.getBytes();
		AppVariables.mChatService.write(send);
	}


	public void goToFourthActivity(View v) {

		Intent i = new Intent(PlayerChoiceDisplay.this, GameResult.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
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
