/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.service.impl;

import com.movies.dao.BaseDao;
import com.movies.entities.lut.Country;
import com.movies.entities.lut.Genre;
import com.movies.service.GeneralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Yener
 */
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private BaseDao baseDao;
    
    @Override
    public List<Country> getAllCountries() {
        return baseDao.getAllObjects(Country.class);
    }

    @Override
    public List<Genre> getAllGenres() {
        return baseDao.getAllObjects(Genre.class);
    }   
    
}
