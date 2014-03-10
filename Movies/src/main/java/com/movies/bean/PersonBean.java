/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.lut.Country;
import com.movies.jsf.JsfUtil;
import com.movies.mapped.Person;
import java.util.HashMap;
import java.util.Map;
import javax.faces.event.ActionEvent;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yener
 */
public abstract class PersonBean {

    private String name;
    private String surname;
    private Country country;
    private Integer chosenMovieId;
    private boolean createUserMode;
    private Person newPerson;
    private Person chosenPerson;
    protected Map<String, Object> parameterMap;

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }

    public abstract Person savePerson(Person person);

    public abstract void updatePerson(Person person);

    public abstract void searchPeople(ActionEvent event);

    public String goToMovieDetail() {
        return JsfUtil.getReturnUrl(MovieConstants.MOVIES_PAGE, MovieConstants.ID_FIELD, String.valueOf(chosenMovieId));
    }

    public abstract void initCreate(ActionEvent event);

    public abstract void cancelCreatePerson(ActionEvent event);

    protected void createParameterMap() {
        parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(name)) {
            parameterMap.put(MovieConstants.NAME_FIELD, name);
        }
        if (StringUtils.isNotBlank(surname)) {
            parameterMap.put(MovieConstants.SURNAME_FIELD, surname);
        }
        if (country != null) {
            parameterMap.put(MovieConstants.COUNTRY_FIELD, country);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
