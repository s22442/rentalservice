package com.pjatk.rentalservice.controller;

import com.pjatk.rentalservice.model.Movie;
import com.pjatk.rentalservice.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Find movie by id", notes = "Retrieving movie by id", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/movies/{id}/rent")
    @ApiOperation(value = "Make movie available by id", notes = "Making movie available by id and retrieving it", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> rentMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.rentMovieById(id));
    }

    @PutMapping("/movies/{id}/return")
    @ApiOperation(value = "Make movie unavailable by id", notes = "Making movie unavailable by id and retrieving it", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> returnMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.returnMovieById(id));
    }
}
