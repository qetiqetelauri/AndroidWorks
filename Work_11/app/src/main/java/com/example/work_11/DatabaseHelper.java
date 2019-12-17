package com.example.work_11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "Users";

    // Table columns
    public static final String User_ID = "userId";
    public static final String _ID = "id";
    public static final String Title = "title";
    public static final String Body = "body";

    // Database Information
    static final String DB_NAME = "UserInformation.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + User_ID
            + " INTEGER, " +_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+ Title + " TEXT NOT NULL, " + Body + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

