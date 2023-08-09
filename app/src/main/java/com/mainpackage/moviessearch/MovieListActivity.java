package com.mainpackage.moviessearch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mainpackage.moviessearch.adapters.MovieRecyclerView;
import com.mainpackage.moviessearch.adapters.OnMovieListener;
import com.mainpackage.moviessearch.models.MovieModel;
import com.mainpackage.moviessearch.viewmodels.MovieListViewModel;


public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    boolean isPopular = true;   // True for popular
    // RecyclerView
    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;
    // ViewModel
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // SearchView
        SetupSearchView();

        recyclerView = findViewById(R.id.recyclerView);
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        ConfigureRecyclerView();
        ObserveAnyChange();
        ObservePopular();
        movieListViewModel.searchMoviePop(1);

        Log.v("Tagy", "ispop: " + isPopular);

    }

    private void ObservePopular() {
        movieListViewModel.getPop().observe(this, movieModels -> {
            // Observing for any data change
            if (movieModels != null) {
                for (MovieModel ignored : movieModels) {
                    // Get the data in log
                    movieRecyclerAdapter.setmMovies(movieModels);


                }
            }

        });


    }


    // Observing any data change
    private void ObserveAnyChange() {
        movieListViewModel.getMovies().observe(this, movieModels -> {
            // Observing for any data change
            if (movieModels != null) {
                for (MovieModel ignored : movieModels) {
                    // Get the data in log
                    movieRecyclerAdapter.setmMovies(movieModels);


                }
            }

        });


    }

    // 5- Initializing recyclerView & adding data to it
    private void ConfigureRecyclerView() {


        movieRecyclerAdapter = new MovieRecyclerView(this);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        // RecyclerView Pagination
        // Loading next page of api response
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1)) {
                    // Here we need to display the next search results on the next page of api
                    movieListViewModel.searchNextpage();

                }

            }
        });


    }

    @Override
    public void onMovieClick(int position) {
        // Toast.makeText(this, "The Position "  +position, Toast.LENGTH_SHORT).show();

        // We don't need position of the movie in recyclerview
        // WE NEED THE ID OF THE MOVIE IN ORDER TO GET ALL IT"S DETAILS

        Intent intent = new Intent(this, MovieDetails.class).setAction("your.custom.action");
        intent.putExtra("movie", movieRecyclerAdapter.getSelectedMovie(position));
        startActivity(intent);


    }

    @Override
    public void onCategoryClick(String category) {

    }

    // Get data from search-view & query the api to get the results (Movies)
    private void SetupSearchView() {
        final SearchView searchView = findViewById(R.id.search_view);


        // Detect Search
        searchView.setOnSearchClickListener(v -> {
            //do what you want when search view expended
            isPopular = false;
            Log.v("Tag", "is-pop: " + false);

        });
        searchView.setOnCloseListener(() -> {
            //do what you want  search-view is not expanded
            return false;
        });


        // Make search query
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieListViewModel.searchMovieApi(
                        // The search string got from search-view
                        query,
                        1
                );
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

}

