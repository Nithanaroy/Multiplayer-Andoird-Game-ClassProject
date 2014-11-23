package com.example.rockpaperscissor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UserChoiceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		if (AppVariables.gameResult != null) {
			AppVariables.gameResult.decideMultiPlayerWinner();
		}

	}

}