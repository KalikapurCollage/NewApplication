package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.Month;
import java.util.Calendar;

public class SeatBookingActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private TextView textViewDate;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_booking);

        getSupportActionBar().setTitle("Searching Buses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerFrom = findViewById(R.id.spinnerFromId);
        spinnerTo = findViewById(R.id.spinnerToId);
        textViewDate = findViewById(R.id.textViewDateId);
        searchButton = findViewById(R.id.searchButtonId);

        textViewDate.setOnClickListener(this);

        //From Location
        Spinner dropdownFrom = findViewById(R.id.spinnerFromId);
        String[] itemsFrom = new String[]{"FROM", "Campus", "Sonapur", "Dotter Haat", "Maijdee", "Chourasta"};
        ArrayAdapter<String> adapterFrom = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsFrom);
        dropdownFrom.setAdapter(adapterFrom);

        //To Location
        Spinner dropdownTo = findViewById(R.id.spinnerToId);
        String[] itemsTo = new String[]{"TO", "Campus", "Sonapur", "Dotter Haat", "Maijdee", "Chourasta"};
        ArrayAdapter<String> adapterTo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsTo);
        dropdownTo.setAdapter(adapterTo);

    }

    @Override
    public void onClick(View v) {

        DatePicker datePicker = new DatePicker(this);
        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = (datePicker.getMonth())+1;
        int currentYear = datePicker.getYear();


    datePickerDialog = new DatePickerDialog(SeatBookingActivity.this,

            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    textViewDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                }
            },currentYear, currentMonth, currentDay);

    datePickerDialog.show();
    }

}
