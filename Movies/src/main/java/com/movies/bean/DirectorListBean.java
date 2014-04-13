/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.Director;
import com.movies.jsf.JsfUtil;
import com.movies.mapped.Person;
import com.movies.service.DirectorService;
import com.movies.util.MovieUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yener
 */
@ManagedBean
@ViewScoped
public class DirectorListBean extends PersonBean implements Serializable {

    private List<Director> directors;
    @ManagedProperty(name = "directorService", value = "#{directorService}")
    private DirectorService directorService;
    
    
    public DirectorListBean(){}
    
    @PostConstruct
    private void init() {
        String param = JsfUtil.getRequestParameter(MovieConstants.ID_FIELD);
        if (StringUtils.isNotEmpty(param)) {
            try{
                directors = Arrays.asList(directorService.getDirectorById(Integer.parseInt(param)));
            } catch(Exception e){
                e.printStackTrace();
                JsfUtil.addErrorMessage("Error. Contact administrator!");
            }
        }
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public Director savePerson(Person person) {
        return directorService.saveDirector((Director) person);
    }

    @Override
    public void updatePerson(Person person) {
        directorService.updateDirector((Director) person);
    }

    @Override
    public void searchPeople(ActionEvent event) {
        try {
            createParameterMap();
            if(MapUtils.isEmpty(parameterMap)){
                directors = directorService.getAllDirectorsWithMovies();
            } else {
                directors = directorService.getDirectorsByCriteria(parameterMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error : " + e.getMessage());
        }
    }

    public void saveDirector(ActionEvent event) {
        try {
            if (MovieUtil.okToSave(getNewPerson())) {
                setNewPerson(savePerson(getNewPerson()));
                directors = Arrays.asList((Director) getNewPerson());
                ((MovieSessionBean) JsfUtil.findBean("movieSessionBean")).updateDirectors();
                JsfUtil.addSuccessMessage("Save successfull");
            } else {
                JsfUtil.addErrorMessage("Fill mandatory fields.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error. Contact administrator!");
        }
    }
    
    public DirectorService getDirectorService() {
        return directorService;
    }

    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public void initCreate(ActionEvent event) {
        setCreateUserMode(true);
        setNewPerson(new Director());
    }

    @Override
    public void cancelCreatePerson(ActionEvent event) {
        setCreateUserMode(false);
        setNewPerson(null);
    }
    
}
