package com.loyal.prueba.controller;

import com.loyal.prueba.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/movies_getList")
    public String[] obtainMoviesList(String moviesName) {
        return movieService.getMovieTitles(moviesName);
    }

}
