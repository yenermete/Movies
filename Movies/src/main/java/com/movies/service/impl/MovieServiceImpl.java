/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.impl;

import com.movies.dao.BaseDao;
import com.movies.db.QueryNames;
import com.movies.entities.Movie;
import com.movies.entities.Movie_;
import com.movies.service.MovieService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.metamodel.SetAttribute;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Yener
 */
public class MovieServiceImpl implements MovieService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Movie> getAllMovies() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_MOVIES);
    }

    @Override
    public List<Movie> getAllMoviesWithActorsAndDirectors() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_MOVIES_WITH_ACTORS_DIRECTORS);
    }
    
    @Override
    public Movie getMovieById(Integer movieId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_MOVIE_BY_ID, "id", movieId);
    }

    @Override
    public List<Movie> getMoviesBySimilarName(String title) {
        return baseDao.findListByNamedQueryAndParam(QueryNames.GET_MOVIES_BY_SIMILAR_NAME, "title", title);
    }

    @Override
    public Movie getMovieWithActors(Integer movieId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_MOVIE_WITH_ACTORS, "id", movieId);
    }

    @Override
    public Movie getMovieWithDirectors(Integer movieId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_MOVIE_WITH_DIRECTORS, "id", movieId);
    }

    @Override
    public Movie getMovieWithActorsAndDirectors(Integer movieId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_MOVIE_WITH_ACTORS_DIRECTORS, "id", movieId);
    }

    @Override
    public void saveMovie(Movie movie) {
        baseDao.mergeEntity(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        baseDao.persistEntity(movie);
        return movie;
    }

    @Override
    public List<Movie> getMoviesByCriteria(Map<String, Object> map) {
        return baseDao.getObjectsByCriteria(map, Movie.class, null, null, Arrays.asList(new SetAttribute[]{Movie_.actors, Movie_.directors, Movie_.genres}));
    }

}
