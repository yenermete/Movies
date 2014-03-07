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
@Table(name = "Actor", schema = "yener")
@SequenceGenerator(
        name = "sequence_person",
        sequenceName = "SEQ_PERSON")
@NamedQueries({
        @NamedQuery(name = QueryNames.GET_ACTOR_BY_ID, query = "select a from Actor a join fetch a.country left join fetch a.movies where a.id = :id"),
        @NamedQuery(name = QueryNames.GET_ACTOR_WITH_MOVIES, query = "select a from Actor a left join fetch a.movies where a.id = :id"),
        @NamedQuery(name = QueryNames.GET_ALL_ACTORS, query = "select a from Actor a join fetch a.country"),
        @NamedQuery(name = QueryNames.GET_ACTOR_BY_SIMILAR_NAME, query = "select a from Actor a join fetch a.country where a.name like '%:name%' or a.surname like '%name%'"),
        @NamedQuery(name = QueryNames.GET_ALL_ACTORS_WITH_MOVIES, query = "select a from Actor a join fetch a.country left join fetch a.movies")})
public class Actor extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_person")
    @Column(name = "ID")
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
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
