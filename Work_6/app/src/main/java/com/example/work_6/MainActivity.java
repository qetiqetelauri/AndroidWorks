package com.example.work_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Program> programList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgramAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ProgramAdapter(programList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        Program program = new Program("@drawable/andoird","android");
        programList.add(program);

         program = new Program("@drawable/java","java");
        programList.add(program);
         program = new Program("@drawable/python","python");
        programList.add(program);
        program = new Program("@drawable/mysql","mysql");
        programList.add(program);
        program = new Program("@drawable/php","php");
        programList.add(program);

        mAdapter.notifyDataSetChanged();
    }
}
