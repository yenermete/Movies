/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
/**
 *
 * @author Yener
 */
public interface BaseDao {
    
    public <T> List<T> findListByNamedQuery(final String queryName);
    
    public <T> List<T> findListByNamedQueryAndParams(final String queryName, Map<String, Object> parameterMap);
    
    public <T> T findUniqueByNamedQueryAndParams(final String queryName, Map<String, Object> parameterMap);
    
    public <T> List<T> findListByNamedQueryAndParam(final String queryName, String key, Object value);
    
    public <T> T findUniqueByNamedQueryAndParam(final String queryName, String key, Object value);
            
    public <T> T mergeEntity(T entity);
    
    public <T> void persistEntity(T entity);
    
    public <T> void deleteEntity(T entity);
    
    public <T> void refreshEntity(T entity);
    
    public <T> List<T> getAllObjects(Class clazz);
    
    public <T> List<T> getObjectsByCriteria(Map<String, Object> map, Class returnClass, List<SingularAttribute> singleAttributes, List<ListAttribute> listAttributes, List<SetAttribute> setAttributes);
    
}
