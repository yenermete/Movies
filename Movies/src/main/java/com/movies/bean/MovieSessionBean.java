/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.bean;

import com.movies.entities.Actor;
import com.movies.entities.Director;
import com.movies.service.ActorService;
import com.movies.service.DirectorService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *This class has all actors and directors in the database when the user's session was initialized. They will be used for movie creation.
 * @author Yener
 */
@ManagedBean
@SessionScoped
public class MovieSessionBean implements Serializable {

    @ManagedProperty(value="#{actorService}")
    private ActorService actorService;
    @ManagedProperty(value="#{directorService}")
    private DirectorService directorService;
    
    private List<Actor> allActors;
    private List<Director> allDirectors;
    /**
     * Creates a new instance of MovieSessionBean
     */
    private void init(){
        allActors = actorService.getAllActors();
        allDirectors  = directorService.getAllDirectors();
    }
    
    public MovieSessionBean() {
    }

    public ActorService getActorService() {
        return actorService;
    }

    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    public DirectorService getDirectorService() {
        return directorService;
    }

    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    public List<Actor> getAllActors() {
        return allActors;
    }

    public void setAllActors(List<Actor> allActors) {
        this.allActors = allActors;
    }

    public List<Director> getAllDirectors() {
        return allDirectors;
    }

    public void setAllDirectors(List<Director> allDirectors) {
        this.allDirectors = allDirectors;
    }
 
    
    
}
