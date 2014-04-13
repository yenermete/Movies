/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service;

import com.movies.entities.Movie;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yener
 */
public interface MovieService {

    public List<Movie> getAllMovies();
    
    public List<Movie> getAllMoviesWithActorsAndDirectors();

    public Movie getMovieById(Integer movieId);

    public List<Movie> getMoviesBySimilarName(String title);

    public Movie getMovieWithActors(Integer movieId);

    public Movie getMovieWithDirectors(Integer movieId);

    public Movie getMovieWithActorsAndDirectors(Integer movieId);

    public void saveMovie(Movie movie);

    public Movie updateMovie(Movie movie);
    
    public List<Movie> getMoviesByCriteria(Map<String, Object> map);
}
