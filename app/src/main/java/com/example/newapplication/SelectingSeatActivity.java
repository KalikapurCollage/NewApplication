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

        //setSingleEvent(gridLayout);
        setToggleEvent(gridLayout);

    }

    private void setToggleEvent(GridLayout gridLayout) {
        //Loop all child item of Grid Layout
        for(int i = 0; i<gridLayout.getChildCount(); i++)
        {
            //You can see, all child item is cardview, so we just cast object of Cardview
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor() == -1)
                    {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#15951A"));
                        ++totalSeats;
                        Toast.makeText(SelectingSeatActivity.this, "You Selected Seat Number : " + (finalI+1), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        --totalSeats;
                        Toast.makeText(SelectingSeatActivity.this, "You Unselected Seat Number : " + (finalI+1), Toast.LENGTH_SHORT).show();

                    }
                    totalBookedSeats.setText(" " + totalSeats);
                }
            });
        }
    }

    private void setSingleEvent(GridLayout gridLayout) {
        //Loop all child item of Grid Layout
        for(int i = 0; i<gridLayout.getChildCount(); i++)
        {
            //You can see, all the child item in Cardview, so we just cast object to cardview
            CardView cardview = (CardView) gridLayout.getChildAt(i);
            int finalI = i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Here you can replace Toast with start New Activity
                    Toast.makeText(SelectingSeatActivity.this, "Clicked in seat "+finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SeatConfirmActivity.class);
        this.startActivity(intent);
    }

    private class Cardview {
    }
}