package com.example.rockpaperscissor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "userDB.db";
	public static final String TABLE_NAME = "userdetail";
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "userName";
	public static final String COLUMN_AGE = "userAge";
	public static final String COLUMN_SEX = "userGender";
	public static final String COLUMN_WINS = "userWins";
	public static final String COLUMN_LOSS = "userLoss";
	
	static String uWin;
	static String uLoss;
	static String uName;
	
	public DBhandler(Context context, String name, 
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	static String u_name="",u_gender="";
	static int u_age,u_win=0,u_loss=0,u_id;
	
	
		
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "create table if not exists userdetail (id integer primary key autoincrement, "
        + "userName VARCHAR not null, userAge INTEGER, userGender VARCHAR, userWins INTEGER, userLoss INTEGER );"; 
	      db.execSQL(CREATE_TABLE);
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	      onCreate(db);
	}
	
	public void addUser(directory d) 
	{
		try
		{
			String query = "select * from userdetail where userName='"+d.get_name()+"' and userAge ="+d.get_age()+"";
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(query, null);
			if(cursor.getCount() != 0)
			{
				cursor.moveToFirst();
				System.out.println("done update");
				u_id = Integer.parseInt(cursor.getString(0));
				u_name = cursor.getString(1);
				u_age = Integer.parseInt(cursor.getString(2));
				u_gender = cursor.getString(3);
				u_win = Integer.parseInt(cursor.getString(4));
				u_loss = Integer.parseInt(cursor.getString(5));
				
			}
			else
			{
										
					u_name=d.get_name();
					u_age=Integer.parseInt(d.get_age());
					u_gender=d.get_sex();
					u_win=0;
					u_loss=0;
			
					try{
				        ContentValues values = new ContentValues();
				        values.put(COLUMN_NAME, u_name);
				        values.put(COLUMN_AGE, u_age);
				        values.put(COLUMN_SEX, u_gender);
				        values.put(COLUMN_WINS, u_win);
				        values.put(COLUMN_LOSS, u_loss);
				        
				        db.insert(TABLE_NAME, null, values);
				        
					}catch(Exception e)
					{
						System.out.println(e);
					}
			}
			db.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void findUser(String name) {
		String query = "select * from userdetail where userName = '"+name+"'";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor != null)
		{
		
			if (cursor.moveToFirst()) {
				cursor.moveToFirst();
				u_id = cursor.getInt(0);
				u_name = cursor.getString(1);
				u_win = Integer.parseInt(cursor.getString(4));
				u_loss = Integer.parseInt(cursor.getString(5));
				cursor.close();
			} 
			else {
				name = "";
			}
		}
		else 
		{
			name="";
		}
	    db.close();
		System.out.println("User Name: "+uName);
		System.out.println("User Win: "+uWin);
		System.out.println("User Loss: "+uLoss);
	}
	
	
	public void winloss()
	{
	
		u_win += GameResult.win;
		u_loss += GameResult.loss;
	}
	
	
	
    // Updating 
	public void onUpdate(int id)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_WINS, u_win);
		values.put(COLUMN_LOSS, u_loss);
		GameResult.win = 0;
		GameResult.loss = 0;
 
		// updating row
		
		//db.rawQuery("UPDATE userdetail SET userWins = "+u_win+", useLoss = "+u_loss+" WHERE userName = '"+u_name+"' and userAge = "+u_age+";", null);
		
		db.update(TABLE_NAME, values, COLUMN_ID + " = "+ u_id, null);
}
	
	
	
	/*
	 *   //---retrieves a particular record---
    public Cursor getRecord(String name) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, TABLE_NAME, new String[] {COLUMN_ID,
                COLUMN_NAME, COLUMN_AGE, COLUMN_SEX, COLUMN_WIN, COLUMN_LOSS}, 
                COLUMN_NAME + "=" + null, name, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String title, String duedate, String course, String notes) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_DUEDATE, duedate);
        args.put(KEY_COURSE, course);
        args.put(KEY_NOTES, notes);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    } 
	 */
	
	
	
	
	
	
	
	
	
	/*public String findProduct(String productname) {
		String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " =  \"" + productname + "\"";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor != null)
		{
		
			if (cursor.moveToFirst()) {
				cursor.moveToFirst();
				//product.set(Integer.parseInt(cursor.getString(0)));
				productname = cursor.getString(1)+"--------"+cursor.getString(2);
				cursor.close();
			} else {
				productname = "";
			}
		}
		else 
		{
			productname="";
		}
	    db.close();
		return productname;
	}*/
		
}

	

