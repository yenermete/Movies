/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.service;

import com.movies.entities.lut.Country;
import com.movies.entities.lut.Genre;
import java.util.List;

/**
 *
 * @author Yener
 */
public interface GeneralService {
    
    public List<Country> getAllCountries();
    public List<Genre> getAllGenres();
}
