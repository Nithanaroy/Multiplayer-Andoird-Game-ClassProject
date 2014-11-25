package com.example.rockpaperscissor;

import android.app.Application;

public class MyApplication extends Application {

	public void onCreate() {
		// Setup handler for uncaught exceptions.
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable e) {
				handleUncaughtException(thread, e);
			}
		});
	}

	public void handleUncaughtException(Thread thread, Throwable e) {
		e.printStackTrace(); // not all Android versions will print the stack trace automatically
		System.exit(1); // kill off the crashed app
	}

	public static BluetoothChatService mChatService;
	public static boolean isSinglePlayer;

	public static String inComingMessage;

	public static GameResult gameResult;

	public static void clearAll(boolean closeConnection) {
		if (closeConnection && mChatService != null) {
			mChatService.stop();
			mChatService = null;
		}
		isSinglePlayer = true;
		inComingMessage = null;
		gameResult = null;

		System.gc();
	}
}