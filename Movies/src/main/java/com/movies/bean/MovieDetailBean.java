/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.Director;
import com.movies.entities.Movie;
import com.movies.jsf.JsfUtil;
import com.movies.service.MovieService;
import com.movies.util.MovieUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yener
 */
@ManagedBean
@ViewScoped
public class MovieDetailBean implements Serializable {

    @ManagedProperty(name = "movieService", value = "#{movieService}")
    private MovieService movieService;
    private List<Movie> movies;

    private String movieName;
    private Director movieDirector;
    private Integer chosenPersonId;
    private Integer personType;
    private boolean createMode = false;
    private Movie newMovie;
    
    private final int actor = MovieConstants.ACTOR;
    private final int director = MovieConstants.DIRECTOR;

    @PostConstruct
    private void init() {
        String param = JsfUtil.getRequestParameter(MovieConstants.ID_FIELD);
        if (StringUtils.isEmpty(param)) {
            movies = movieService.getAllMoviesWithActorsAndDirectors();
        } else {
            movies = Arrays.asList(movieService.getMovieById(Integer.parseInt(param)));
        }
    }

    public String goToPersonDetail() {
        String url = null;
        if (personType == actor) {
            url = MovieConstants.ACTORS_PAGE;
        } else if (personType == director) {
            url = MovieConstants.DIRECTORS_PAGE;
        } else {
            JsfUtil.addErrorMessage("Wrong parameter. Contact administrators");
        }
        return StringUtils.isBlank(url) ? null : JsfUtil.getReturnUrl(url, MovieConstants.ID_FIELD, String.valueOf(chosenPersonId));
    }

    public MovieDetailBean() {}

    public void searchMovies(ActionEvent event){
        Map<String, Object> parameterMap = new HashMap<>();
        if(StringUtils.isNotBlank(movieName)){
            parameterMap.put(MovieConstants.MOVIE_TITLE_FIELD, movieName);
        }
        if(movieDirector != null) {
            parameterMap.put(MovieConstants.MOVIE_DIRECTOR_FIELD, movieDirector.getId());
        }
        try {
            movies = movieService.getMoviesByCriteria(parameterMap);
        } catch (Exception e){
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error. Contact administrator!");
        }
    }
    
    public void initCreateMovie(ActionEvent event){createMode = true;newMovie = new  Movie();}
    
    public void createMovie(ActionEvent event){
        try{
            if(MovieUtil.okToSave(newMovie)){
                movieService.saveMovie(newMovie);
                movies = Arrays.asList(newMovie);
                createMode = false;
                newMovie = new Movie();
            } else{JsfUtil.addErrorMessage("Fill all mandatory fields!");}
        } catch(Exception e){
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error. Contact administrator!");
        }
    }
    
    public void cancelCreateMovie(ActionEvent event){
        newMovie = new Movie();
        createMode = false;
    }
    
    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public int getActor() {
        return actor;
    }

    public int getDirector() {
        return director;
    }

    public Integer getChosenPersonId() {
        return chosenPersonId;
    }

    public void setChosenPersonId(Integer chosenPersonId) {
        this.chosenPersonId = chosenPersonId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Director getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(Director movieDirector) {
        this.movieDirector = movieDirector;
    }

    public boolean isCreateMode() {
        return createMode;
    }

    public void setCreateMode(boolean createMode) {
        this.createMode = createMode;
    }

    public Movie getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(Movie newMovie) {
        this.newMovie = newMovie;
    }

}
