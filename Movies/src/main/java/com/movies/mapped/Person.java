/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.mapped;

import com.movies.constants.MovieConstants;
import com.movies.entities.lut.Country;
import com.movies.enumeration.SexEnum;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 *
 * @author Yener
 */
@MappedSuperclass
public class Person {

    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "MIDDLE_NAME", length = 15)
    private String middleName;
    @Column(name = "SURNAME", length = 20)
    private String surname;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Country country;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Type(
            type = "com.movies.enumeration.generic.GenericEnumUserType",
            parameters = {
                @Parameter(
                        name = "enumClass",
                        value = "com.movies.enumeration.SexEnum"),
                @Parameter(
                        name = "identifierMethod",
                        value = "intoString"),
                @Parameter(
                        name = "valueOfMethod",
                        value = "fromString")
            }
    )
    @Column(name = "SEX")
    private SexEnum sex;
    @Transient
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getFullName() {
        if (StringUtils.isBlank(fullName)) {
            createFullName();
        }
        return fullName;
    }
    
    private void createFullName() {
        fullName = getStringWithPadding(name, MovieConstants.RIGHT_PAD)
                + getStringWithPadding(middleName, MovieConstants.RIGHT_PAD) + surname;
    }

    public void refreshPerson() {
        createFullName();
    }

    private String getStringWithPadding(final String string, final int paddingType) {
        if (StringUtils.isNotBlank(string)) {
            switch (paddingType) {
                case MovieConstants.LEFT_PAD:
                    return StringUtils.leftPad(string, string.length() + 1);
                case MovieConstants.RIGHT_PAD:
                    return StringUtils.rightPad(string, string.length() + 1);
                default:
                    throw new IllegalArgumentException("String should be padded either from left or right!");
            }
        } else {
            return "";
        }
    }
}
