/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.entities;

import com.movies.db.QueryNames;
import com.movies.mapped.Person;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Yener
 */
@Entity
@Table(name = "DIRECTOR", schema = "yener")
@SequenceGenerator(
        name = "sequence_person",
        sequenceName = "SEQ_PERSON")
@NamedQueries({
        @NamedQuery(name = QueryNames.GET_DIRECTOR_BY_ID, query = "select d from Director d join fetch d.country left join fetch d.movies where d.id = :id"),
        @NamedQuery(name = QueryNames.GET_ALL_DIRECTORS_WITH_COUNTRIES, query = "select d from Director d join fetch d.country"),
        @NamedQuery(name = QueryNames.GET_ALL_DIRECTORS, query = "from Director"),
        @NamedQuery(name = QueryNames.GET_ALL_DIRECTORS_WITH_MOVIES, query = "select distinct d from Director d left join fetch d.movies join fetch d.country"),
        @NamedQuery(name = QueryNames.GET_DIRECTORS_BY_SIMILAR_NAME, query = "select distinct d from Director d left join fetch d.movies join fetch d.country where d.name like '%:name%' or d.surname like '%name%'")})
public class Director extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_person")
    @Column(name = "ID")
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "directors")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
