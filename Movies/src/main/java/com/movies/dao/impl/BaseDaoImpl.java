/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.dao.impl;

import com.movies.dao.BaseDao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import java.util.Map.Entry;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yener
 */
public class BaseDaoImpl implements BaseDao {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public <T> List<T> findListByNamedQuery(final String queryName) {
        return em.createNamedQuery(queryName).getResultList();
    }

    @Override
    public <T> List<T> findListByNamedQueryAndParams(final String queryName, Map<String, Object> parameterMap) {
        return getQuery(queryName, parameterMap).getResultList();
    }

    @Override
    public <T> T findUniqueByNamedQueryAndParams(final String queryName, Map<String, Object> parameterMap) {
        return (T) getQuery(queryName, parameterMap).getSingleResult();
    }

    @Override
    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    @Override
    public <T> void persistEntity(T entity) {
        em.persist(entity);
    }

    @Override
    public <T> void deleteEntity(T entity) {
        em.remove(entity);
    }

    @Override
    public <T> void refreshEntity(T entity) {
        getEntityManager().refresh(entity);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public <T> List<T> findListByNamedQueryAndParam(String queryName, String key, Object value) {
        return em.createNamedQuery(queryName).setParameter(key, value).getResultList();
    }

    @Override
    public <T> T findUniqueByNamedQueryAndParam(String queryName, String key, Object value) {
        return (T) em.createNamedQuery(queryName).setParameter(key, value).getSingleResult();
    }

    
    @Override
    public <T> List<T> getObjectsByCriteria(Map<String, Object> map, Class clazz) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public <T> List<T> getAllObjects(Class clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> object = cq.from(clazz);
        cq.select(object);
        TypedQuery<T> q = em.createQuery(cq);
        return q.getResultList();
    }

    private Query getQuery(final String queryName, Map<String, Object> parameterMap) {
        Query query = em.createNamedQuery(queryName);
        Set<Entry<String, Object>> set = parameterMap.entrySet();
        for (Entry<String, Object> entry : set) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
