package com.example.rockpaperscissor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UserChoiceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		if (MyApplication.gameResult != null) {
			MyApplication.gameResult.decideMultiPlayerWinner();
		}

	}

}