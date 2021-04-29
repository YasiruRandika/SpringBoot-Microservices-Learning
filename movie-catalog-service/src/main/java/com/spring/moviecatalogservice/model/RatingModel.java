package com.spring.moviecatalogservice.model;

public class RatingModel {
    private int movieId;
    private int ratings;
    
    public RatingModel() {
    }

    public RatingModel(int movieId, int ratings) {
        this.movieId = movieId;
        this.ratings = ratings;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    
}
