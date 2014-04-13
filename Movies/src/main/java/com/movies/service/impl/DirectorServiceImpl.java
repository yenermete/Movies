/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.impl;

import com.movies.dao.BaseDao;
import com.movies.db.QueryNames;
import com.movies.entities.Director;
import com.movies.entities.Director_;
import com.movies.service.DirectorService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Yener
 */
public class DirectorServiceImpl implements DirectorService {
    
    @Autowired
    private BaseDao baseDao;
    
    @Override
    public List<Director> getAllDirectorsWithCountries() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_DIRECTORS_WITH_COUNTRIES);
    }
    
    @Override
    public List<Director> getAllDirectorsWithMovies() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_DIRECTORS_WITH_MOVIES);
    }
    
    @Override
    public List<Director> getDirectorsWithSimilarName(String name) {
        return baseDao.findListByNamedQueryAndParam(QueryNames.GET_DIRECTORS_BY_SIMILAR_NAME, "name", name);
    }
    
    @Override
    public Director getDirectorById(Integer directorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_DIRECTOR_BY_ID, "id", directorId);
    }
    
    @Override
    public Director getDirectorWithMovies(Integer directorId) {
        return baseDao.findUniqueByNamedQueryAndParam(QueryNames.GET_DIRECTOR_WITH_MOVIES, "id", directorId);
    }
    
    @Override
    public Director saveDirector(Director director) {
        return baseDao.mergeEntity(director);
    }
    
    @Override
    public void updateDirector(Director director) {
        baseDao.persistEntity(director);
    }

    @Override
    public List<Director> getAllDirectors() {
        return baseDao.findListByNamedQuery(QueryNames.GET_ALL_DIRECTORS);
    }
    
    @Override
    public List<Director> getDirectorsByCriteria(Map<String, Object> map){
        return baseDao.getObjectsByCriteria(map, Director.class, Arrays.asList(new SingularAttribute[]{Director_.country}), Arrays.asList(new ListAttribute[]{Director_.movies}), null);
    }
}
