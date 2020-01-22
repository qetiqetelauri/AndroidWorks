package com.example.final_ketiketelauri;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;

import com.example.final_ketiketelauri.Model.Cost;
import com.example.final_ketiketelauri.Model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Manager";

    // Table Names
    private static final String TABLE_Schedule = "schedule";
    private static final String TABLE_Cost = "cost";

    // Common column names
    private static final String KEY_ID = "id";

    // schedule Table - column names
    private static final String KEY_ScheduleTime = "scheduleTime";
    private static final String KEY_ScheduleAbout = "scheduleAbout";
    private static final String KEY_ScheduleDuration = "scheduleDuration";


    // cost Table - column names
    private static final String KEY_CostTime = "costTime";
    private static final String KEY_Costcost = "costcost";
    private static final String KEY_CostAbout = "costAbout";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_Schedule = "CREATE TABLE "
            + TABLE_Schedule + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ScheduleTime
            + " TEXT," + KEY_ScheduleAbout + " TEXT," + KEY_ScheduleDuration
            + " INTEGER" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_COST = "CREATE TABLE " + TABLE_Cost
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CostTime + " TEXT,"
            + KEY_Costcost + " INTEGER," + KEY_CostAbout
            + " TEXT" +  ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_Schedule);
        db.execSQL(CREATE_TABLE_COST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Cost);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Schedule);

        // create new tables
        onCreate(db);
    }


    //Crude//



    /**
     * Creating a schedule
     */
    public long createToSchedule(Schedule schedule) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put (KEY_ScheduleTime, schedule.getScheduleTime());
        values.put(KEY_ScheduleAbout, schedule.getScheduleAbout());
        values.put(KEY_ScheduleDuration,schedule.getScheduleDuration());


        // insert row
        long schedule_id = db.insert(TABLE_Schedule, null, values);


        return schedule_id;
    }



    /**
     * getting all schedule
     * */
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<Schedule>();
        String selectQuery = "SELECT  * FROM " + TABLE_Schedule;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Schedule td = new Schedule();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setScheduleTime((c.getString(c.getColumnIndex(KEY_ScheduleTime))));
                td.setScheduleAbout(c.getString(c.getColumnIndex(KEY_ScheduleAbout)));
                td.setScheduleDuration(c.getInt(c.getColumnIndex(KEY_ScheduleDuration)));


                // adding to todo list
                schedules.add(td);
            } while (c.moveToNext());
        }

        return schedules;
    }


//    public int updateSchedule(Schedule schedule) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_Done, schedule.getDone());
//
//
//        // updating row
//        return db.update(TABLE_Schedule, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(schedule.getId()) });
//    }
    public long createCost(Cost cost) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put (KEY_CostTime, cost.getCostTime());
        values.put(KEY_CostAbout, cost.getCostAbout());
        values.put(KEY_Costcost,cost.getCostcost());


        // insert row
        long schedule_id = db.insert(TABLE_Cost, null, values);


        return schedule_id;
    }



    /**
     * getting all schedule
     * */
    public List<Cost> getAllCost() {
        List<Cost> costs = new ArrayList<Cost>();
        String selectQuery = "SELECT  * FROM " + TABLE_Cost;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Cost td = new Cost();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setCostTime((c.getString(c.getColumnIndex(KEY_CostTime))));
                td.setCostAbout(c.getString(c.getColumnIndex(KEY_CostAbout)));
                td.setCostcost(c.getInt(c.getColumnIndex(KEY_Costcost)));


                // adding to todo list
                costs.add(td);
            } while (c.moveToNext());
        }

        return costs;
    }


}
