package com.example.rockpaperscissor;

import android.app.Application;

public class AppVariables extends Application {

	public static BluetoothChatService mChatService;
	public static boolean isSinglePlayer;

	public static String inComingMessage;

	public static GameResult gameResult;

	public static void clearAll() {
		mChatService = null;
		isSinglePlayer = true;
		inComingMessage = null;
		gameResult = null;
	}
}