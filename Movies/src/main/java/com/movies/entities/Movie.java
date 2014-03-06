/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.entities;

import com.movies.db.QueryNames;
import com.movies.entities.lut.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author Yener
 */
@Entity
@Table(name = "Movie", schema = "yener")
@SequenceGenerator(
        name = "sequence_movie",
        sequenceName = "SEQ_MOVIE")
@NamedQueries({
    @NamedQuery(name = QueryNames.GET_MOVIE_BY_ID, query = "select m from Movie m join fetch m.genres join fetch m.directors join fetch m.actors where m.id = :id"),
    @NamedQuery(name = QueryNames.GET_ALL_MOVIES, query = "select m from Movie m"),
    @NamedQuery(name = QueryNames.GET_ALL_MOVIES_WITH_ACTORS_DIRECTORS, query = "select distinct m from Movie m join fetch m.actors join fetch m.directors join fetch m.genres"),
    @NamedQuery(name = QueryNames.GET_MOVIES_BY_SIMILAR_NAME, query = "select m from Movie m where m.title like '%:title%'"),
    @NamedQuery(name = QueryNames.GET_MOVIE_WITH_ACTORS, query = "select m from Movie m join fetch m.actors where m.id = :id"),
    @NamedQuery(name = QueryNames.GET_MOVIE_WITH_DIRECTORS, query = "select m from Movie m join fetch m.directors where m.id = :id"),
    @NamedQuery(name = QueryNames.GET_MOVIE_WITH_ACTORS_DIRECTORS, query = "select distinct m from Movie m join fetch m.actors join fetch m.directors join fetch m.genres where m.id = :id")})
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_movie")
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITLE", length = 50)
    private String title;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_DIRECTOR", joinColumns = {
        @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "DIRECTOR_ID", referencedColumnName = "ID", nullable = false))
    private Set<Director> directors;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_ACTOR", joinColumns = {
        @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID", nullable = false))
    private Set<Actor> actors;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_GENRE", joinColumns = {
        @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID", nullable = false))
    private Set<Genre> genres;
    @Transient
    //@Column(name = "AVERAGE_POINT", precision = 1, scale = 2)
    private Long averagePoint;
    @Transient
    private List<Actor> actorsList;
    @Transient
    private List<Director> directorsList;
    @Transient
    private List<Genre> genresList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Long getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(Long averagePoint) {
        this.averagePoint = averagePoint;
    }

    public List<Actor> getActorsList() {
        if(CollectionUtils.isEmpty(actorsList) && CollectionUtils.isNotEmpty(actors)){
            actorsList = new ArrayList<>(actors);
        }
        return actorsList;
    }

    public List<Director> getDirectorsList() {
        if(CollectionUtils.isEmpty(directorsList) && CollectionUtils.isNotEmpty(directors)){
            directorsList = new ArrayList<>(directors);
        }
        return directorsList;
    }

    public List<Genre> getGenresList() {
        if(CollectionUtils.isEmpty(genresList) && CollectionUtils.isNotEmpty(genres)){
            genresList = new ArrayList<>(genres);
        }
        return genresList;
    }

}
