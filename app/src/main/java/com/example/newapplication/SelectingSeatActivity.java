package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SelectingSeatActivity extends AppCompatActivity implements View.OnClickListener {

    private GridLayout gridLayout;
    private int totalSeats = 0;
    private TextView totalBookedSeats;
    private Button buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_seat);

        getSupportActionBar().setTitle("Select Your Favorite Seat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridLayout = findViewById(R.id.mainGridId);
        totalBookedSeats = findViewById(R.id.totalSeatsId);
        buttonBook = findViewById(R.id.buttonBookId);

        buttonBook.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SeatConfirmActivity.class);
        this.startActivity(intent);
    }
}