package com.spring.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import com.spring.ratingdataservice.model.RatingModel;
import com.spring.ratingdataservice.model.UserRating;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @RequestMapping("/{id}")
    public ResponseEntity getRatingByID(@PathVariable("id") int movieId) {
        return new ResponseEntity<>(new RatingModel(movieId, 5), HttpStatus.OK);
    }

    @RequestMapping("users/{id}")
    public ResponseEntity getRatingsForUser(@PathVariable("id") int userId) {
        List<RatingModel> ratings = Arrays.asList(
            new RatingModel(1, 5),
            new RatingModel(2, 4)
        );

        UserRating userRating = new UserRating(ratings);
        return new ResponseEntity<>(userRating, HttpStatus.OK);
    }
}
