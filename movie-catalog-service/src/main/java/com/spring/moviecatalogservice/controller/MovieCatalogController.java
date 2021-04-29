package com.spring.moviecatalogservice.controller;

import java.util.List;

import com.spring.moviecatalogservice.model.CatalogItem;
import com.spring.moviecatalogservice.service.CatalogServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired 
    CatalogServiceImpl catalogService;

    @GetMapping("")
    public ResponseEntity getAllMovies() {
        List<CatalogItem> movies = catalogService.getAllMovies();
        
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Movies Found", HttpStatus.NOT_FOUND);
        }
    }
}
