/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.util;

import com.movies.entities.Movie;
import com.movies.mapped.Person;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yener
 */
public class MovieUtil {
    
    /**
     * Checks if it is ok to save a person object. Mandatory fields are #{@link Person#name}, #{@link Person#surname}, #{@link Person#birthDate}, #{@link Person#sex} and #{@link Person#country}.
     * @param person
     * @return true if it is ok to save, false otherwise. 
     */
    public static boolean okToSave(Person person){
        return person != null && StringUtils.isNotBlank(person.getName()) && StringUtils.isNotBlank(person.getSurname())
                && person.getBirthDate() != null && person.getCountry() != null && person.getSex() != null;
    }
    
    public static boolean okToSave(Movie movie){
        return movie != null && StringUtils.isNotBlank(movie.getTitle()) && CollectionUtils.isNotEmpty(movie.getDirectors())
                && CollectionUtils.isNotEmpty(movie.getActors()) && CollectionUtils.isNotEmpty(movie.getGenres());
    }
    
}
