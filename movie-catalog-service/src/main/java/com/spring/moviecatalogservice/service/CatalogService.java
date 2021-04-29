package com.spring.moviecatalogservice.service;

import java.util.List;

import com.spring.moviecatalogservice.model.CatalogItem;

public interface CatalogService {
    public List<CatalogItem> getAllMovies();
}
