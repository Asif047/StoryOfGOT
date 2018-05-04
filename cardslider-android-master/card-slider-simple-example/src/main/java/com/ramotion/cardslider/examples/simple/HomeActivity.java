package com.ramotion.cardslider.examples.simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ramotion.cardslider.examples.simple.Season2.Season2Activity;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout season1Layout;
    private RelativeLayout season2Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        season1Layout = findViewById(R.id.season1_layout);
        season2Layout = findViewById(R.id.season2_layout);

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

    }
}
