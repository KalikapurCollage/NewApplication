package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TeacherInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info);

        getSupportActionBar().setTitle("Teacher's Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}