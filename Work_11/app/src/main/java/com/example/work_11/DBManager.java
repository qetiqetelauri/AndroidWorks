package com.example.work_11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String title, String body,long UserID) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.Title, title);
        contentValue.put(DatabaseHelper.Body, body);
        contentValue.put(DatabaseHelper.User_ID, UserID);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.User_ID,  DatabaseHelper.Body, DatabaseHelper.Title };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String title, String body,long UserID) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.Title, title);
        contentValues.put(DatabaseHelper.Body, body);
        contentValues.put(DatabaseHelper.User_ID, UserID);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {

        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}


