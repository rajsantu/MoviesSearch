package com.mainpackage.moviessearch.models;

import android.os.Parcel;

public class MovieModelBuilder {
    private String posterPath;
    private float voteAverage;
    private String title;
    private String releaseDate;
    private int movieId;
    private String movieOverview;
    private String originalLanguage;
    private Parcel in;

    public MovieModelBuilder setPoster_path(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public MovieModelBuilder setVote_average(float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public MovieModelBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieModelBuilder setRelease_date(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public MovieModelBuilder setMovie_id(int movieId) {
        this.movieId = movieId;
        return this;
    }

    public MovieModelBuilder setMovie_overview(String movieOverview) {
        this.movieOverview = movieOverview;
        return this;
    }

    public MovieModelBuilder setOriginal_language(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public MovieModelBuilder setIn(Parcel in) {
        this.in = in;
        return this;
    }

    public MovieModel createMovieModel() {
        return new MovieModel(posterPath, voteAverage);
    }
}