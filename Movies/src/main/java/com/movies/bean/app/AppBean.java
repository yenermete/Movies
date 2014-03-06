/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.bean.app;

import com.movies.entities.lut.Country;
import com.movies.entities.lut.Genre;
import com.movies.service.GeneralService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Yener
 */
@ManagedBean(eager = true)
@SessionScoped
public class AppBean implements Serializable{

    @ManagedProperty(name="generalService", value = "#{generalService}")
    private GeneralService generalService;
    
    private List<Country> countryList;
    private List<Genre> genreList;
    
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
    
    
    
}
