/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.bean;

import com.movies.constants.MovieConstants;
import com.movies.entities.Actor;
import com.movies.jsf.JsfUtil;
import com.movies.mapped.Person;
import com.movies.service.ActorService;
import com.movies.util.MovieUtil;
import javax.faces.event.ActionEvent;
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
public class ActorListBean extends PersonBean implements Serializable {

    private List<Actor> actors;
    @ManagedProperty(name = "actorService", value = "#{actorService}")
    private ActorService actorService;

    public ActorListBean() {
    }

    @PostConstruct
    private void init() {
        String param = JsfUtil.getRequestParameter(MovieConstants.ID_FIELD);
        if (StringUtils.isNotEmpty(param)) {
            try {
                actors = Arrays.asList(actorService.getActorById(Integer.parseInt(param)));
            } catch (Exception e) {
                e.printStackTrace();
                JsfUtil.addErrorMessage("Error. Contact administrator!");
            }
        }
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public ActorService getActorService() {
        return actorService;
    }

    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public Actor savePerson(Person person) {
        return actorService.saveActor((Actor) person);
    }

    public void saveActor(ActionEvent event) {
        try {
            if (MovieUtil.okToSave(getNewPerson())) {
                setNewPerson(savePerson(getNewPerson()));
                setCreateUserMode(false);
                actors = Arrays.asList((Actor)getNewPerson());
                JsfUtil.addSuccessMessage("Save successfull");
            } else {
                JsfUtil.addErrorMessage("Fill mandatory fields.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error. Contact administrator!");
        }
    }

    @Override
    public void updatePerson(Person person) {
        actorService.updateActor((Actor) person);
    }

    @Override
    public void searchPeople(ActionEvent event) {
        try {
            actors = actorService.getAllActorsWithMovies();
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.addErrorMessage("Error : " + e.getMessage());
        }
    }

   @Override
    public void initCreate(ActionEvent event) {
        setCreateUserMode(true);
        setNewPerson(new Actor());
    }

    @Override
    public void cancelCreatePerson(ActionEvent event) {
        setCreateUserMode(false);
        setNewPerson(null);
    }

    
}
