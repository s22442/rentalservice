package com.pjatk.rentalservice.service;

import com.pjatk.rentalservice.model.Movie;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    private static final String MOVIES_URL = "http://localhost:8080/movies";

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieById(Integer id) {
        return this.restTemplate.exchange(MOVIES_URL + "/" + id, HttpMethod.GET, null, Movie.class).getBody();
    }

    public Movie rentMovieById(Integer id) {
        return this.restTemplate.exchange(MOVIES_URL + "/" + id + "/unavailable", HttpMethod.PUT, null, Movie.class).getBody();
    }

    public Movie returnMovieById(Integer id) {
        return this.restTemplate.exchange(MOVIES_URL + "/" + id + "/available", HttpMethod.PUT, null, Movie.class).getBody();
    }
}
