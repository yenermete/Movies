/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.impl;

import com.movies.constants.MovieConstants;
import com.movies.dao.BaseDao;
import com.movies.db.QueryNames;
import com.movies.entities.Actor;
import com.movies.entities.Actor_;
import com.movies.entities.lut.Country;
import com.movies.mapped.Person;
import com.movies.service.ActorService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Yener
 */
public class ActorServiceImpl implements ActorService {
    
    @Autowired
    private BaseDao baseDao;
    
    @Override
    public List<Actor> getAllActorsWithCountries() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_ACTORS_WITH_COUNTRY);
    }
    
    @Override
    public List<Actor> getAllActorsWithMovies() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_ACTORS_WITH_MOVIES);
    }
    
    @Override
    public Actor getActorById(Integer actorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_ACTOR_BY_ID, MovieConstants.ID_FIELD, actorId);
    }
    
    @Override
    public Actor getActorWithMovies(Integer actorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_ACTOR_WITH_MOVIES,  MovieConstants.ID_FIELD, actorId);
    }
    
    @Override
    public List<Actor> getActorsWithSimilarName(String name) {
        return baseDao.findListByNamedQueryAndParam(QueryNames.GET_ACTOR_BY_SIMILAR_NAME,  MovieConstants.NAME_FIELD, name);
    }
    
    @Override
    public List<Actor> getActorsByCriteria(Map<String, Object> map){
        return baseDao.getObjectsByCriteria(map, Actor.class, new SingularAttribute[]{Actor_.country}, new ListAttribute[]{Actor_.movies});
    }
    
    @Override
    public Actor saveActor(Actor actor) {
        return baseDao.mergeEntity(actor);
    }
    
    @Override
    public void updateActor(Actor actor) {
        baseDao.persistEntity(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_ACTORS);
    }

}
