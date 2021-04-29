package com.spring.ratingdataservice.model;

import java.util.List;

public class UserRating {
    private List<RatingModel> userRatings;

    public UserRating(List<RatingModel> userRatings) {
        this.userRatings = userRatings;
    }

    public UserRating() {
    }

    public List<RatingModel> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<RatingModel> userRatings) {
        this.userRatings = userRatings;
    }

    
}
