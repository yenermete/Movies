/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.movies.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Yener
 */
@FacesConverter("upperCaseConverter")
public class UpperCaseConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value == null ? null : value.toString().toUpperCase();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return StringUtils.isBlank(value) ? null : value.toUpperCase();
    }

}
