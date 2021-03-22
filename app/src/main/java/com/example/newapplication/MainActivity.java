package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    GridLayout mainGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerId);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.nav_open,R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mainGridLayout = findViewById(R.id.mainGridLayoutId);
        setSingal(mainGridLayout);

    }

    private void setSingal(GridLayout mainGridLayout) {



        for(int pos = 0; pos<mainGridLayout.getChildCount(); pos++)
        {
            CardView cardView = (CardView)mainGridLayout.getChildAt(pos);
            final int finalI = pos;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0)
                    {
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1)
                    {
                        Intent intent = new Intent(MainActivity.this,ScheduleActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 2)
                    {
                        Intent intent = new Intent(MainActivity.this,TeacherInfoActivity.class);
                        startActivity(intent);
                    }

                    else if(finalI == 3)
                    {
                        Intent intent = new Intent(MainActivity.this,StoppageActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 4)
                    {
                        Intent intent = new Intent(MainActivity.this,TrackingActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 5)
                    {
                        Intent intent = new Intent(MainActivity.this,SeatBookingActivity.class);
                        startActivity(intent);
                    }

                    else if(finalI == 6)
                    {
                        Intent intent = new Intent(MainActivity.this,ContactsActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 7)
                    {
                        Intent intent = new Intent(MainActivity.this,AboutNstuActivity.class);
                        startActivity(intent);
                    }
                    else if(finalI == 8)
                    {
                        Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}