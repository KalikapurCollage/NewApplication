package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    GridLayout mainGridLayout;

    AlertDialog.Builder admin_alert;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.navigationViewId);

        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        admin_alert = new AlertDialog.Builder(this);
        inflater = this.getLayoutInflater();

        mainGridLayout = findViewById(R.id.mainGridLayoutId);
        setSingal(mainGridLayout);

    }

    private void setSingal(GridLayout mainGridLayout) {


        for (int pos = 0; pos < mainGridLayout.getChildCount(); pos++) {
            CardView cardView = (CardView) mainGridLayout.getChildAt(pos);
            final int finalI = pos;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(MainActivity.this, TeacherInfoActivity.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(MainActivity.this, StoppageActivity.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(MainActivity.this, TrackingActivity.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        Intent intent = new Intent(MainActivity.this, SeatBookingActivity.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                        startActivity(intent);
                    } else if (finalI == 7) {
                        Intent intent = new Intent(MainActivity.this, AboutNstuActivity.class);
                        startActivity(intent);
                    } else if (finalI == 8) {
                        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if(id == R.id.adminmenuId){

                View view = inflater.inflate(R.layout.admin_layout, null);
                admin_alert.setTitle("For Admin Panel")
                        .setMessage("Enter Admin Passcode for Admin Panel login")
                        .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText passcode = view.findViewById(R.id.adminPopId);
                                if(passcode.getText().toString().isEmpty()){
                                    passcode.setError("Required Filed");
                                    Toast.makeText(getApplicationContext(), "Enter Admin valid Passcode",Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                                String confirmpasscode = "Ahmed123";
                                String userpasscode = passcode.getText().toString();

                                if(confirmpasscode.equalsIgnoreCase(userpasscode))
                                {
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(), "Admin Panel Enter Successfully",Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "Enter correct Admin Passcode", Toast.LENGTH_SHORT).show();
                                    passcode.requestFocus();
                                }
                            }
                        }).setNegativeButton("Cancel", null)
                        .setView(view)
                        .create().show();
        }

        return super.onOptionsItemSelected(item);

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.resetPasswordId:
                startActivity(new Intent(getApplicationContext(), ResetPassword.class));
                break;

            case R.id.logoutId:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                finish();
                break;
        }

        return  false;
    }

}