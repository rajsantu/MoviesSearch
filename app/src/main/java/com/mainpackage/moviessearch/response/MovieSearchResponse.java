package com.mainpackage.moviessearch.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mainpackage.moviessearch.models.MovieModel;

import java.util.List;

// This class is for getting multiple movies (Movies list) - popular movies
public class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose()
    private int total_count;


    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies;

    public MovieSearchResponse(int totalCount, List<MovieModel> movies) {
        total_count = totalCount;
        this.movies = movies;
    }


    public List<MovieModel> getMovies() {
        return movies;

    }

    @NonNull
    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
