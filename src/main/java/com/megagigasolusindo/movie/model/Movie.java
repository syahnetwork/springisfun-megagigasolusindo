package com.megagigasolusindo.movie.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movie")
public class Movie {
    private String title, description, addedBy, genreOther, countryOther;
    private int id, year, status, voters, ratingSum;
    private double ratingAvgNum;
    private Set<String> genreList;
    private Set<String> countryList;
    private Set<String> directorsNames;
    private Set<String> leadActorsNames;
    private Set<Celebrity> directors;
    private Set<Celebrity> leadActors;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_director", joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")})
    public Set<Celebrity> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Celebrity> directors) {
        this.directors = directors;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_leadactors", joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    public Set<Celebrity> getLeadActors() {
        return leadActors;
    }

    public void setLeadActors(Set<Celebrity> leadActors) {
        this.leadActors = leadActors;
    }

    @ElementCollection
    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genrelist")
    public Set<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<String> genreList) {
        this.genreList = genreList;
    }

    @Column(name = "genre_other")
    public String getGenreOther() {
        return genreOther;
    }

    public void setGenreOther(String genreOther) {
        this.genreOther = genreOther;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ElementCollection
    @CollectionTable(name = "movie_country", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "countrylist")
    public Set<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(Set<String> countryList) {
        this.countryList = countryList;
    }

    @Column(name = "country_other")
    public String getCountryOther() {
        return countryOther;
    }

    public void setCountryOther(String countryOther) {
        this.countryOther = countryOther;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "added_by")
    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    @Column(name = "voters")
    public int getVoters() {
        return voters;
    }

    public void setVoters(int voters) {
        this.voters = voters;
    }

    @Column(name = "rating_sum")
    public int getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(int ratingSum) {
        this.ratingSum = ratingSum;
    }

    @Column(name = "rating_avg_num")
    public double getRatingAvgNum() {
        return ratingAvgNum;
    }

    public void setRatingAvgNum(double ratingAvgNum) {
        this.ratingAvgNum = ratingAvgNum;
    }

    @Transient
    public String getRatingAvg() {
        String ratingAvg = "�.�";
        if (voters != 0) {
            ratingAvg = Double.toString(ratingAvgNum);
        }
        return ratingAvg;
    }

    @Transient
    public String getStatusValue() {
        HashMap<Integer, String> statusValues = new HashMap<Integer, String>();
        statusValues.put(1, "validated");
        statusValues.put(0, "pending validation");
        statusValues.put(-1, "rejected");
        return statusValues.get(getStatus());
    }

    @Transient
    public Set<Celebrity> getAllCelebs() {
        Set<Celebrity> movieCelebs = new HashSet<Celebrity>();
        movieCelebs.addAll(directors);
        movieCelebs.addAll(leadActors);
        return movieCelebs;
    }

    @Transient
    public Set<String> getDirectorsNames() {
        return directorsNames;
    }

    public void setDirectorsNames(Set<String> directorsNames) {
        this.directorsNames = directorsNames;
    }

    @Transient
    public Set<String> getLeadActorsNames() {
        return leadActorsNames;
    }

    public void setLeadActorsNames(Set<String> leadActorsNames) {
        this.leadActorsNames = leadActorsNames;
    }

    @Transient
    private String getGenreString() {
        String genreString = genreList.toString().replace("[", "").replace("]", "");
        if (!genreString.equals("") && genreOther != null && !genreOther.equals(""))
            genreString = genreString + ", " + genreOther;
        if (genreString.equals("")) genreString = genreOther;
        return genreString;
    }

    @Transient
    private String getCountryString() {
        String countryString = countryList.toString().replace("[", "").replace("]", "");
        if (!countryString.equals("") && countryOther != null && !countryOther.equals(""))
            countryString = countryString + ", " + countryOther;
        if (countryString.equals("")) countryString = countryOther;
        return countryString;
    }

    @Transient
    public String getDirectorString() {
        String directorString = directors.toString().replace("[", "").replace("]", "");
        return directorString;
    }

    @Transient
    public String getLeadActorsString() {
        String leadActorsString = leadActors.toString().replace("[", "").replace("]", "");
        return leadActorsString;
    }

    public String toString() {
        return "title: " + title + "<br>director: " + getDirectorString() + "<br>genre: " + getGenreString() + "<br>lead actors: "
                + getLeadActorsString() + "<br>year: " + year + "<br>country: " + getCountryString() + "<br>description: " + description;
    }

}