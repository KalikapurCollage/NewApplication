package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SeatConfirmActivity extends AppCompatActivity {

    private EditText teachersName, departmentName, seatNumber, passcodeNo;
    private Button seatBookedButton;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_confirm);

        getSupportActionBar().setTitle("Confirm Bus Seat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseReference = FirebaseDatabase.getInstance().getReference("Teachers");

        teachersName = findViewById(R.id.teacherNameEditTextId);
        departmentName = findViewById(R.id.departmentNameEditTextId);
        seatNumber = findViewById(R.id.seatNumberEditTextId);
        passcodeNo = findViewById(R.id.passcodeEditTextId);
        seatBookedButton = findViewById(R.id.seatBookedButtonId);

        seatBookedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookedData();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

            private void bookedData() {

                String name = teachersName.getText().toString().trim();
                String department = departmentName.getText().toString().trim();
                String seatNo = seatNumber.getText().toString().trim();
                String passcode = passcodeNo.getText().toString().trim();


                String key = databaseReference.push().getKey();

                Teachers teachers = new Teachers(name, department, seatNo, passcode);
                databaseReference.child(key).setValue(teachers);
                Toast.makeText(getApplicationContext(), "Seat is booked successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
}