/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service;

import com.movies.entities.Actor;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yener
 */
public interface ActorService {

    public List<Actor> getAllActorsWithCountries();

    public List<Actor> getAllActors();

    public List<Actor> getAllActorsWithMovies();

    public Actor getActorById(Integer actorId);

    public Actor getActorWithMovies(Integer actorId);

    public List<Actor> getActorsWithSimilarName(String name);

    public Actor saveActor(Actor actor);

    public void updateActor(Actor actor);

    public List<Actor> getActorsByCriteria(Map<String, Object> map);

}
