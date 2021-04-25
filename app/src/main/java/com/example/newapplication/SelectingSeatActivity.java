package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelectingSeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_seat);

        getSupportActionBar().setTitle("Selecting Bus Seat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}