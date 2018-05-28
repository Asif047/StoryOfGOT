package com.ramotion.cardslider.examples.simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ramotion.cardslider.examples.simple.Season2.Season2Activity;
import com.ramotion.cardslider.examples.simple.Season3.Season3Activity;
import com.ramotion.cardslider.examples.simple.Season4.Season4Activity;
import com.ramotion.cardslider.examples.simple.Season5.Season5Activity;
import com.ramotion.cardslider.examples.simple.Season6.Season6Activity;
import com.ramotion.cardslider.examples.simple.Season7.Season7Activity;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout season1Layout;
    private RelativeLayout season2Layout;
    private RelativeLayout season3Layout;
    private RelativeLayout season4Layout;
    private RelativeLayout season5Layout;
    private RelativeLayout season6Layout;
    private RelativeLayout season7Layout;

    Animation fromLeftToRight, fromRightToLeft;

    LinearLayout linearLayout;
    int[] drawablearray=new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3,
                            R.drawable.b4, R.drawable.b5};
    Timer _t;
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        season1Layout = findViewById(R.id.season1_layout);
        season2Layout = findViewById(R.id.season2_layout);
        season3Layout = findViewById(R.id.season3_layout);
        season4Layout = findViewById(R.id.season4_layout);
        season5Layout = findViewById(R.id.season5_layout);
        season6Layout = findViewById(R.id.season6_layout);
        season7Layout = findViewById(R.id.season7_layout);


        fromLeftToRight = AnimationUtils.loadAnimation(this, R.anim.from_left_to_right);
        fromRightToLeft = AnimationUtils.loadAnimation(this, R.anim.from_right_to_left);

        season1Layout.setAnimation(fromLeftToRight);
        season2Layout.setAnimation(fromRightToLeft);

        season3Layout.setAnimation(fromLeftToRight);
        season4Layout.setAnimation(fromRightToLeft);

        season5Layout.setAnimation(fromLeftToRight);
        season6Layout.setAnimation(fromRightToLeft);

        season7Layout.setAnimation(fromLeftToRight);



        //background starts

        linearLayout =  findViewById(R.id.home_background);
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


        season1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        season2Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season2Activity.class);
                startActivity(intent);
            }
        });

        season3Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season3Activity.class);
                startActivity(intent);
            }
        });

        season4Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season4Activity.class);
                startActivity(intent);
            }
        });

        season5Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season5Activity.class);
                startActivity(intent);
            }
        });

        season6Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season6Activity.class);
                startActivity(intent);
            }
        });

        season7Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Season7Activity.class);
                startActivity(intent);
            }
        });

    }
}
