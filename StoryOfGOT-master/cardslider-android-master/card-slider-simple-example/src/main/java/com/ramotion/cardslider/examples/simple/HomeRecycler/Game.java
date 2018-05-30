package com.ramotion.cardslider.examples.simple.HomeRecycler;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("season_name")
    @Expose
    private String seasonName;
    @SerializedName("released_date")
    @Expose
    private String releasedDate;
    @SerializedName("num_of_episodes")
    @Expose
    private String numOfEpisodes;
    @SerializedName("avg_imdb_rating")
    @Expose
    private String avgImdbRating;
    @SerializedName("img")
    @Expose
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getNumOfEpisodes() {
        return numOfEpisodes;
    }

    public void setNumOfEpisodes(String numOfEpisodes) {
        this.numOfEpisodes = numOfEpisodes;
    }

    public String getAvgImdbRating() {
        return avgImdbRating;
    }

    public void setAvgImdbRating(String avgImdbRating) {
        this.avgImdbRating = avgImdbRating;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
