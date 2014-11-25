package com.example.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class SingleMultiChoiceActivity extends ActionBarActivity {

	String TAG = "RPS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_multi);
	}

	public void startSingleGamePlay(View v) {
		try {
			Log.d(TAG, "Single Player");
			MyApplication.isSinglePlayer = true;
			Intent i = new Intent (SingleMultiChoiceActivity.this, PlayerChoice.class);
	    	startActivity(i);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

	public void startMultiGamePlay(View v) {
		try {
			Log.d(TAG, "Multi Player");
			MyApplication.isSinglePlayer = false;
			Intent i = new Intent (SingleMultiChoiceActivity.this, BluetoothChat.class);
	    	startActivity(i);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}
}