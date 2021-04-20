package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ScheduleActivity extends AppCompatActivity {

    private ListView listView;
    private String[] busName, busTime;
    private int[] busImage = {R.drawable.bus_picture};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getSupportActionBar().setTitle("Bus Schedule");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listViewId);

        busName = getResources().getStringArray(R.array.bus_name);
        busTime = getResources().getStringArray(R.array.bus_time);

        CustomAdapter adapter = new CustomAdapter(this, busName, busTime, busImage);
        listView.setAdapter(adapter);
    }
}