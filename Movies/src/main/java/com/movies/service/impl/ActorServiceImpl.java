/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.impl;

import com.movies.dao.BaseDao;
import com.movies.db.QueryNames;
import com.movies.entities.Actor;
import com.movies.service.ActorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Yener
 */
public class ActorServiceImpl implements ActorService {
    
    @Autowired
    private BaseDao baseDao;
    
    @Override
    public List<Actor> getAllActors() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_ACTORS);
    }
    
    @Override
    public List<Actor> getAllActorsWithMovies() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_ACTORS_WITH_MOVIES);
    }
    
    @Override
    public Actor getActorById(Integer actorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_ACTOR_BY_ID, "id", actorId);
    }
    
    @Override
    public Actor getActorWithMovies(Integer actorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_ACTOR_WITH_MOVIES, "id", actorId);
    }
    
    @Override
    public List<Actor> getActorsWithSimilarName(String name) {
        return baseDao.findListByNamedQueryAndParam(QueryNames.GET_ACTOR_BY_SIMILAR_NAME, "name", name);
    }
    
    @Override
    public Actor saveActor(Actor actor) {
        return baseDao.mergeEntity(actor);
    }
    
    @Override
    public void updateActor(Actor actor) {
        baseDao.persistEntity(actor);
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

}
