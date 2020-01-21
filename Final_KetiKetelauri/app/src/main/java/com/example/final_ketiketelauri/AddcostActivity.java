package com.example.final_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.final_ketiketelauri.Model.Schedule;

public class AddcostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcost);

        Button add = (Button) findViewById(R.id.add_schedule);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Schedule sc = new Schedule()
            }
        });
    }
}
