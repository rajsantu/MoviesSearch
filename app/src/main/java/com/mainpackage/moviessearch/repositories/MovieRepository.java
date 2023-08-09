package com.mainpackage.moviessearch.repositories;

import androidx.lifecycle.LiveData;

import com.mainpackage.moviessearch.models.MovieModel;
import com.mainpackage.moviessearch.request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    // This class is acting as repositories

    private static MovieRepository instance;

    private final MovieApiClient movieApiClient;

    private String mQuery;
    private int mPageNumber;


    private MovieRepository() {

        movieApiClient = MovieApiClient.getInstance();
    }

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;

    }

    public LiveData<List<MovieModel>> getMovies() {
        return movieApiClient.getMovies();
    }

    // 2- Calling the method in repository
    public void serachMovieApi(String query, int pageNumber) {
        mQuery = query;
        mPageNumber = pageNumber;
        movieApiClient.searchMoviesApi(query, pageNumber);
    }


    public void searchNextPage() {
        serachMovieApi(mQuery, mPageNumber + 1);
    }


    public LiveData<List<MovieModel>> getPop() {
        return movieApiClient.getPop();
    }

    // 2- Calling the method in repository
    public void serachMoviePop(int pageNumber) {

        mPageNumber = pageNumber;
        movieApiClient.searchMoviesPop(pageNumber);
    }

}




