package com.ramotion.cardslider.examples.simple;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ramotion.cardslider.examples.simple.HomeRecycler.Home3Activity;
import com.ramotion.cardslider.examples.simple.Season2.Season2Activity;
import com.ramotion.cardslider.examples.simple.Season3.Season3Activity;
import com.ramotion.cardslider.examples.simple.Season4.Season4Activity;
import com.ramotion.cardslider.examples.simple.Season5.Season5Activity;
import com.ramotion.cardslider.examples.simple.Season6.Season6Activity;
import com.ramotion.cardslider.examples.simple.Season7.Season7Activity;

import java.util.Timer;
import java.util.TimerTask;

public class Home2Activity extends AppCompatActivity {

    private TextView tvSeason1, tvSeason2, tvSeason3, tvSeason4,
                        tvSeason5, tvSeason6, tvSeason7, tvSeason8;

    private CardView cardSeason1, cardSeason2, cardSeason3, cardSeason4,
                        cardSeason5, cardSeason6, cardSeason7, cardSeason8;

    ImageView ivCard;

    LinearLayout linearLayout;
    int[] drawablearray=new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3,
            R.drawable.b4, R.drawable.b5, R.drawable.b6};
    Timer _t;
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        ivCard = findViewById(R.id.imageview_card);

        tvSeason1 = findViewById(R.id.textview_season1);
        tvSeason2 = findViewById(R.id.textview_season2);
        tvSeason3 = findViewById(R.id.textview_season3);
        tvSeason4 = findViewById(R.id.textview_season4);
        tvSeason5 = findViewById(R.id.textview_season5);
        tvSeason6 = findViewById(R.id.textview_season6);
        tvSeason7 = findViewById(R.id.textview_season7);
        tvSeason8 = findViewById(R.id.textview_season8);

        cardSeason1 = findViewById(R.id.cardview_season1);
        cardSeason2 = findViewById(R.id.cardview_season2);
        cardSeason3 = findViewById(R.id.cardview_season3);
        cardSeason4 = findViewById(R.id.cardview_season4);
        cardSeason5 = findViewById(R.id.cardview_season5);
        cardSeason6 = findViewById(R.id.cardview_season6);
        cardSeason7 = findViewById(R.id.cardview_season7);
        cardSeason8 = findViewById(R.id.cardview_season8);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts_diavlo/Diavlo_BOLD_II_37.otf");

        tvSeason1.setTypeface(tf);
        tvSeason2.setTypeface(tf);
        tvSeason3.setTypeface(tf);
        tvSeason4.setTypeface(tf);
        tvSeason5.setTypeface(tf);
        tvSeason6.setTypeface(tf);
        tvSeason7.setTypeface(tf);
        tvSeason8.setTypeface(tf);

        ivCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Home3Activity.class);
                startActivity(intent);
            }
        });

        cardSeason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        cardSeason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season2Activity.class);
                startActivity(intent);
            }
        });


        cardSeason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season3Activity.class);
                startActivity(intent);
            }
        });


        cardSeason4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season4Activity.class);
                startActivity(intent);
            }
        });


        cardSeason5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season5Activity.class);
                startActivity(intent);
            }
        });


        cardSeason6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season6Activity.class);
                startActivity(intent);
            }
        });


        cardSeason7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2Activity.this, Season7Activity.class);
                startActivity(intent);
            }
        });




        //background starts

        linearLayout =  findViewById(R.id.home2_background);
        linearLayout.setBackgroundResource(R.drawable.b1);
        _t = new Timer();
        _t.scheduleAtFixedRate(new TimerTask() {
            @Override            public void run() {

                runOnUiThread(new Runnable() {
                    public void run() {
                        if (count < drawablearray.length) {

                            linearLayout.setBackgroundResource(drawablearray[count]);
                            count = (count + 1) % drawablearray.length;
                        }
                    }
                });
            }
        }, 2000, 3000);

        //background ends



    }
}
