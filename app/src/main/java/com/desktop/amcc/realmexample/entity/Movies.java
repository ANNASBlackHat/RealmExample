package com.desktop.amcc.realmexample.entity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ANNASBlackHat on 4/18/2016.
 */
public class Movies extends RealmObject {
    @PrimaryKey
    private int idMovie;
    private String movieTitle;
    private String releaseDate;
    private int runtime;
    private RealmList<Genre> genreList;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public RealmList<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(RealmList<Genre> genreList) {
        this.genreList = genreList;
    }
}
