package com.ramotion.cardslider.examples.simple.HomeRecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ramotion.cardslider.examples.simple.Home2Activity;
import com.ramotion.cardslider.examples.simple.R;

import java.util.List;

public class Home3Activity extends AppCompatActivity {


    private List<Game> data;

    private RecyclerView recyclerView;
    private RecyclerAdapterGame recyclerAdapterGame;
    private RecyclerView.LayoutManager layoutManager;

    private ImageView ivGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        ivGrid = findViewById(R.id.imageview_grid);
        ivGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home3Activity.this, Home2Activity.class);
                startActivity(intent);
            }
        });

        data = Utils.loadGame(this);

        recyclerView = findViewById(R.id.recyclerview_home3);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapterGame = new RecyclerAdapterGame(Home3Activity.this, data);
        recyclerView.setAdapter(recyclerAdapterGame);
    }
}
