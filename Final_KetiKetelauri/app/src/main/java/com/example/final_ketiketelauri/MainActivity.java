package com.example.final_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.final_ketiketelauri.Model.Cost;
import com.example.final_ketiketelauri.Model.Schedule;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    private TextView mTxtcostDisplay;
    private TextView mTxtscheduleDisplay;
    private static final String NEW_LINE = "\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getApplicationContext());
        setContentView(R.layout.activity_main);
        Button buttonAddScedule = (Button) findViewById(R.id.btnAddSchedule);
        Button buttonAddCost = (Button) findViewById(R.id.btnAddCost);
        mTxtcostDisplay = (TextView) findViewById(R.id.txtcostDisplay);
        mTxtscheduleDisplay = (TextView) findViewById(R.id.txtscheduleDisplay);
        buttonAddScedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        AddscheduleActivity.class);
                startActivity(myIntent);
            }
        });
        buttonAddCost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        AddcostActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void getAllSchedule(){
        List<Schedule> allSchedules = db.getAllSchedules();
        StringBuilder textViewData = new StringBuilder();
        for (Schedule schedule : allSchedules) {
            textViewData.append("Time: ")
                    .append(schedule.getScheduleTime().toString()).append(NEW_LINE);
            textViewData.append("About: ").append(schedule.getScheduleAbout()).append(NEW_LINE);
        }
        mTxtscheduleDisplay.setText(textViewData.toString());
    }
    public void getAllCost(){
        List<Cost> allCost = db.getAllCost();
        StringBuilder textViewData = new StringBuilder();
        for (Cost cost : allCost) {
            textViewData.append("Time: ")
                    .append(cost.getCostTime().toString()).append(NEW_LINE);
            textViewData.append("About: ").append(cost.getCostTime()).append(NEW_LINE);
        }
        mTxtscheduleDisplay.setText(textViewData.toString());
    }
}