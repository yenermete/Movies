/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.db;

/**
 *
 * @author Yener
 */
public class QueryNames {
    
    public static final String GET_ALL_ACTORS = "getAllActors";
    public static final String GET_ACTOR_BY_SIMILAR_NAME = "getActorsBySimilarName";
    public static final String GET_ACTOR_BY_ID = "getActorById";
    public static final String GET_ACTOR_WITH_MOVIES = "getActorWithMovies";
    public static final String GET_ALL_ACTORS_WITH_MOVIES = "getActorsWithMovies";
    
    public static final String GET_ALL_MOVIES = "getAllMovies";
    public static final String GET_ALL_MOVIES_WITH_ACTORS_DIRECTORS = "getAllMoviesWithActorsDirectors";
    public static final String GET_MOVIE_BY_ID = "getMovieById";
    public static final String GET_MOVIES_BY_SIMILAR_NAME = "getMovieBySimilarNAme";
    public static final String GET_MOVIE_WITH_ACTORS = "getMovieWithActors";
    public static final String GET_MOVIE_WITH_DIRECTORS = "getMovieWithDirectors";
    public static final String GET_MOVIE_WITH_ACTORS_DIRECTORS = "getMovieWithActorsAndDirectors";
    
    public static final String GET_ALL_DIRECTORS = "getAllDirectors";
    public static final String GET_ALL_DIRECTORS_WITH_MOVIES="getAllDirectorsWithMovies";
    public static final String GET_DIRECTOR_WITH_MOVIES = "getDirectorWithMovies";
    public static final String GET_DIRECTOR_BY_ID = "getDirectorById";
    public static final String GET_DIRECTORS_BY_SIMILAR_NAME = "getDirectorsBySimilarName";
}
