package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SeatBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_booking);

        getSupportActionBar().setTitle("Seat Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}