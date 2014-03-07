/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service;

import com.movies.entities.Director;
import java.util.List;

/**
 *
 * @author Yener
 */
public interface DirectorService {

    public List<Director> getAllDirectors();
    
    public List<Director> getAllDirectorsWithMovies();

    public List<Director> getDirectorsWithSimilarName(String name);

    public Director getDirectorById(Integer directorId);

    public Director getDirectorWithMovies(Integer directorId);

    public Director saveDirector(Director director);

    public void updateDirector(Director director);
}
