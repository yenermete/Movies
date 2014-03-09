/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.bean.app;

import com.movies.entities.lut.Country;
import com.movies.entities.lut.Genre;
import com.movies.enumeration.SexEnum;
import com.movies.service.GeneralService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Yener
 */
@ManagedBean()
@ApplicationScoped
public class AppBean implements Serializable {

    @ManagedProperty(name="generalService", value = "#{generalService}")
    private GeneralService generalService;
    
    private List<Country> countryList;
    private List<Genre> genreList;
    private List<SexEnum> sexList = Arrays.asList(SexEnum.MALE, SexEnum.FEMALE);
    
    /**
     * Creates a new instance of AppBean
     */
    public AppBean() {
    }
    
    @PostConstruct
    private void init(){
        countryList = generalService.getAllCountries();
        genreList = generalService.getAllGenres();
    }

    public GeneralService getGeneralService() {
        return generalService;
    }

    public void setGeneralService(GeneralService generalService) {
        this.generalService = generalService;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public List<SexEnum> getSexList() {
        return sexList;
    }

    public void setSexList(List<SexEnum> sexList) {
        this.sexList = sexList;
    }
    
}
