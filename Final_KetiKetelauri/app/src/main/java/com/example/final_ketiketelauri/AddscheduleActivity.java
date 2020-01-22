package com.example.final_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_ketiketelauri.Model.Cost;
import com.example.final_ketiketelauri.Model.Schedule;

import static java.lang.Integer.parseInt;

public class AddscheduleActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addschedule);
        db = new DatabaseHelper(getApplicationContext());
        Button add = (Button) findViewById(R.id.add_schedule);
        final EditText schedule_EditTime = findViewById(R.id.schedule_EditTime);
        final EditText  schedule_EditAbout = findViewById(R.id.schedule_EditAbout);
        final EditText schedule_EditDuration = findViewById(R.id.schedule_EditDuration);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Schedule cs = new Schedule(schedule_EditTime.getText().toString(), schedule_EditAbout.getText().toString(), parseInt(schedule_EditDuration.getText().toString()));
                db.createToSchedule(cs);
            }
        });
    }
}
