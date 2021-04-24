package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class SeatBookingActivity extends AppCompatActivity implements View.OnClickListener {

    private TimePicker timePicker;

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private TextView textViewTimer;
    private int timeHour, timeMinute;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_booking);

        getSupportActionBar().setTitle("Searching Buses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerFrom = findViewById(R.id.spinnerFromId);
        spinnerTo = findViewById(R.id.spinnerToId);
        searchButton = findViewById(R.id.searchButtonId);

        textViewTimer = findViewById(R.id.textViewTimeId);
        textViewTimer.setOnClickListener(this);

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
        //Initialize time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                SeatBookingActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Initialize hour And minute
                        timeHour = hourOfDay;
                        timeMinute = minute;
                        //Store hour and minute in String
                        String time = timeHour +":"+ timeMinute;
                        //Initialize 24 hours time format
                        SimpleDateFormat f24Hours = new SimpleDateFormat(
                                "HH:mm"
                        );
                        try {
                            Date date = f24Hours.parse(time);
                            //Initilize 12Hours time format
                            SimpleDateFormat f12Hours = new SimpleDateFormat(
                                    "hh:mm aa"
                            );
                            //Set Selected time on text view
                            textViewTimer.setText(f12Hours.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                },12,0,false
        );
        //Set transparent background
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Display previous Selected time
        timePickerDialog.updateTime(timeHour,timeMinute);
        //Show Dialog
        timePickerDialog.show();
    }

}
