package com.mainpackage.moviessearch.response;


import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mainpackage.moviessearch.models.MovieModel;

// This class is for single movie request
public class MovieResponse {
    // 1- Finding the Movie Object

    @SerializedName("results")
    @Expose
    private MovieModel movie;


    @NonNull
    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
