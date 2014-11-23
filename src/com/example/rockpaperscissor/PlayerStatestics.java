package com.example.rockpaperscissor;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PlayerStatestics extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		
		AppVariables.clearAll();

		try {
			DBhandler dbh = new DBhandler(this, null, null, 1);
			dbh.findUser(dbh.u_name);
			dbh.winloss();


			TextView uname = (TextView) findViewById(R.id.user_name_answer);
			TextView uwin = (TextView) findViewById(R.id.wins_answer);
			TextView uloss = (TextView) findViewById(R.id.loss_answer);

			uname.setText(dbh.u_name.toString());
			uwin.setText(dbh.u_win + "");
			uloss.setText(dbh.u_loss + "");

			dbh.onUpdate(dbh.u_id);
			dbh.close();
		} catch (Exception e) {

		}
	}

	public void playAgain(View v) {
		Intent i = new Intent(PlayerStatestics.this, SingleMultiChoiceActivity.class);
		startActivity(i);
	}

	public void exitGame(View v) {
		finish();
		moveTaskToBack(true);
		
		// TODO: Close bluetooth connection
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fifth, menu);
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
