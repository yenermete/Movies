/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.Movie;
import com.movies.jsf.JsfUtil;
import com.movies.service.MovieService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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
    private Integer chosenPersonId;
    private Integer personType;
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

    public MovieDetailBean() {
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

}
