package com.spring.moviecatalogservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.moviecatalogservice.model.CatalogItem;
import com.spring.moviecatalogservice.model.Movie;
import com.spring.moviecatalogservice.model.RatingModel;
import com.spring.moviecatalogservice.model.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder wBuilder;

    /*
    public List<CatalogItem> getAllMovies() {
        List<RatingModel> ratings = Arrays.asList(
            new RatingModel(1, 5),
            new RatingModel(2, 4)
        );
    
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Description", rating.getRatings());
        }).collect(Collectors.toList());
    }
    */

    /**
     * Using WebClient Builder
     */
    public List<CatalogItem> getAllMovies() {
        //List<RatingModel> ratings = restTemplate.getForObject("http://localhost:8082/ratings/users/" + 4, UserRating.class).getUserRatings();
    
        //Using Ureka 
        List<RatingModel> ratings = restTemplate.getForObject("http://rating-data-service/ratings/users/" + 4, UserRating.class).getUserRatings();

        return ratings.stream().map(rating -> {
            Movie movie = wBuilder.build()
            .get()
            .uri("http://localhost:8081/movies/" + rating.getMovieId())
            .retrieve()
            .bodyToMono(Movie.class).block();

            return new CatalogItem(movie.getName(), "Description", rating.getRatings());
        }).collect(Collectors.toList());
    }
    
}
