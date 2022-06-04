package com.pjatk.rentalservice.controller;

import com.pjatk.rentalservice.model.Movie;
import com.pjatk.rentalservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    public MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/movies/{id}/rent")
    public ResponseEntity<Movie> rentMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.rentMovieById(id));
    }

    @PutMapping("/movies/{id}/return")
    public ResponseEntity<Movie> returnMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.returnMovieById(id));
    }
}
