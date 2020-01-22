package com.example.final_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_ketiketelauri.Model.Cost;
import com.example.final_ketiketelauri.Model.Schedule;

import static java.lang.Integer.parseInt;

public class AddcostActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcost);
        db = new DatabaseHelper(getApplicationContext());
        Button add =  findViewById(R.id.add_cost);
        final EditText cost_EditTime = findViewById(R.id.cost_EditTime);
        final EditText  cost_EditCost = findViewById(R.id.cost_EditCost);
        final EditText cost_EditAbout = findViewById(R.id.cost_EditAbout);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Cost cs = new Cost(cost_EditTime.getText().toString(),parseInt(cost_EditCost.getText().toString()),(cost_EditAbout.getText().toString()));
                db.createCost(cs);
            }
        });
    }
}
