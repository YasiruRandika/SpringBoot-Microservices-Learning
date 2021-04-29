package com.spring.movieinfoservice.controller;

import com.spring.movieinfoservice.model.Movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @RequestMapping("/{id}")
    public ResponseEntity getRatingByID(@PathVariable("id") int movieId) {
        return new ResponseEntity<>(new Movie(movieId, "Super Man"), HttpStatus.OK);
    }
}
