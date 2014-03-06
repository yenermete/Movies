/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.enumeration;

import com.movies.constants.MovieConstants;

/**
 *
 * @author Yener
 */
public enum SexEnum {

    FEMALE(MovieConstants.FEMALE), MALE(MovieConstants.MALE);

    private final String sex;

    private SexEnum(String sex) {this.sex = sex;}

    public String getSex() {return sex;}

    public static SexEnum fromString(String value) {
        switch (value) {
            case MovieConstants.FEMALE:
                return FEMALE;
            case MovieConstants.MALE:
                return MALE;
            default :
                throw new IllegalArgumentException("Invalid column value for sex field!");
        }
    }
    
    public String intoString() {return sex;}

    public static String getSexEnum(String value) {
        switch (value) {
            case (MovieConstants.FEMALE):
                return FEMALE.toString();
            case (MovieConstants.MALE):
                return MALE.toString();
            default:
                throw new IllegalArgumentException("Invalid column value for sex field!");
        }
    }
}
