package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    CustomAdapter adapter;
    private String[] busName, busFrom, busTo, busTime;
    private int[] images = {R.drawable.bus_picture};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getSupportActionBar().setTitle("Bus Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewId);

        busName = getResources().getStringArray(R.array.bus_name);
        busFrom = getResources().getStringArray(R.array.bus_from);
        busTo = getResources().getStringArray(R.array.bus_to);
        busTime = getResources().getStringArray(R.array.bus_time);

         adapter = new CustomAdapter(this, busName, busFrom, busTo, busTime, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}