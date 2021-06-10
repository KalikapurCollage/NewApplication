package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.GridLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    GridLayout mainGridLayout;
    private Menu menu;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.navigationViewId);

        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
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

    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.aboutAdminId:
                startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                break;

            case R.id.resetPasswordId:
                startActivity(new Intent(getApplicationContext(),ResetPassword.class));
                break;

            case R.id.logoutId:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                finish();
                break;

        }
        return false;
    }
}