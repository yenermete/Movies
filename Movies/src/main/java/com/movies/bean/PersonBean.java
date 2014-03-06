/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.lut.Country;
import com.movies.entities.lut.Genre;
import com.movies.jsf.JsfUtil;
import com.movies.mapped.Person;
import javax.faces.event.ActionEvent;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yener
 */
public abstract class PersonBean {

    private String name;
    private Country selectedCountry;
    private Genre selectedGenre;
    private Integer chosenMovieId;
    private Person chosenPerson;
    private Person newPerson;
    private boolean createUserMode;
    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {}
    
    public abstract void savePerson(Person person);
    
    public abstract void updatePerson(Person person);

    public abstract void searchPeople(ActionEvent event);
    
    public String goToMovieDetail(){
        return JsfUtil.getReturnUrl(MovieConstants.MOVIES_PAGE, MovieConstants.ID_FIELD, String.valueOf(chosenMovieId));
    }
    
    public void initCreate(ActionEvent event){
        createUserMode = true;
        newPerson = new Person();
    }
    
    public void cancelCreatePerson(ActionEvent event){
        createUserMode = false;
        newPerson = null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Country selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public Genre getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(Genre selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public Integer getChosenMovieId() {
        return chosenMovieId;
    }

    public void setChosenMovieId(Integer chosenMovieId) {
        this.chosenMovieId = chosenMovieId;
    }

    public Person getChosenPerson() {
        return chosenPerson;
    }

    public void setChosenPerson(Person chosenPerson) {
        this.chosenPerson = chosenPerson;
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }

    public boolean isCreateUserMode() {
        return createUserMode;
    }

    public void setCreateUserMode(boolean createUserMode) {
        this.createUserMode = createUserMode;
    }
    
}
