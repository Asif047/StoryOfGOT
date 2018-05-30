package com.ramotion.cardslider.examples.simple.HomeRecycler;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.cardslider.examples.simple.MainActivity;
import com.ramotion.cardslider.examples.simple.R;
import com.ramotion.cardslider.examples.simple.Season2.Season2Activity;
import com.ramotion.cardslider.examples.simple.Season3.Season3Activity;
import com.ramotion.cardslider.examples.simple.Season4.Season4Activity;
import com.ramotion.cardslider.examples.simple.Season5.Season5Activity;
import com.ramotion.cardslider.examples.simple.Season6.Season6Activity;
import com.ramotion.cardslider.examples.simple.Season7.Season7Activity;

import java.util.List;

public class RecyclerAdapterGame extends RecyclerView.Adapter<RecyclerAdapterGame.MyViewHolder> {

    private List<Game> games;
    private Context context;

    public RecyclerAdapterGame( Context context, List<Game> games) {
        this.games = games;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_game,
                            parent, false);

        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvSeasonNum.setText(games.get(position).getSeasonName());
        holder.tvNumOfEpi.setText(games.get(position).getNumOfEpisodes());
        holder.tvImdbRating.setText(games.get(position).getAvgImdbRating());
        holder.tvReleasedDate.setText(games.get(position).getReleasedDate());

        if(games.get(position).getSeasonName().equals("Season 1")) {
            holder.ivSeason.setImageResource(R.drawable.season1);
        }

        if(games.get(position).getSeasonName().equals("Season 2")) {
            holder.ivSeason.setImageResource(R.drawable.season2);
        }

        if(games.get(position).getSeasonName().equals("Season 3")) {
            holder.ivSeason.setImageResource(R.drawable.season3);
        }

        if(games.get(position).getSeasonName().equals("Season 4")) {
            holder.ivSeason.setImageResource(R.drawable.season4);
        }

        if(games.get(position).getSeasonName().equals("Season 5")) {
            holder.ivSeason.setImageResource(R.drawable.season5);
        }

        if(games.get(position).getSeasonName().equals("Season 6")) {
            holder.ivSeason.setImageResource(R.drawable.season6);
        }

        if(games.get(position).getSeasonName().equals("Season 7")) {
            holder.ivSeason.setImageResource(R.drawable.season7);
        }


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                if(pos == 0) {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }


                if(pos == 1) {
                    Intent intent = new Intent(context, Season2Activity.class);
                    context.startActivity(intent);
                }

                if(pos == 2) {
                    Intent intent = new Intent(context, Season3Activity.class);
                    context.startActivity(intent);
                }

                if(pos == 3) {
                    Intent intent = new Intent(context, Season4Activity.class);
                    context.startActivity(intent);
                }

                if(pos == 4) {
                    Intent intent = new Intent(context, Season5Activity.class);
                    context.startActivity(intent);
                }

                if(pos == 5) {
                    Intent intent = new Intent(context, Season6Activity.class);
                    context.startActivity(intent);
                }

                if(pos == 6) {
                    Intent intent = new Intent(context, Season7Activity.class);
                    context.startActivity(intent);
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return games.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvSeasonNum, tvReleasedDate, tvImdbRating, tvNumOfEpi;
        ImageView ivSeason;

        ItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvSeasonNum = itemView.findViewById(R.id.textview_season_num);
            tvReleasedDate = itemView.findViewById(R.id.textview_released_date);
            tvImdbRating = itemView.findViewById(R.id.textview_imdb_rating);
            tvNumOfEpi = itemView.findViewById(R.id.textview_number_of_epi);

            ivSeason = itemView.findViewById(R.id.imageview_season);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            this.itemClickListener.onItemClick(this.getLayoutPosition());

        }
    }

}
