package com.mainpackage.moviessearch.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class MovieModel implements Parcelable {
    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModelBuilder().setIn(in).createMovieModel();
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
    private final String poster_path;
    private final float vote_average;
    // Model Class for our movies
    private String title;
    private String release_date;
    private int movie_id;
    // We have missed it :)
    @SerializedName("overview")
    private String movie_overview;


    //Constructor
    private String original_language;

    public MovieModel(String poster_path, float vote_average) {
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }

    public MovieModel(String title, String poster_path, String release_date, int movie_id, float vote_average, String movie_overview, String original_language) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.movie_overview = movie_overview;
        this.original_language = original_language;

    }

    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        movie_id = in.readInt();
        vote_average = in.readFloat();
        movie_overview = in.readString();
        original_language = in.readString();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getMovie_overview() {
        return movie_overview;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeString(release_date);
        parcel.writeInt(movie_id);
        parcel.writeFloat(vote_average);
        parcel.writeString(movie_overview);
        parcel.writeString(original_language);

    }


    @NonNull
    @Override
    public String toString() {
        return "MovieModel{" +
                "title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", movie_id=" + movie_id +
                ", vote_average=" + vote_average +
                ", movie_overview='" + movie_overview + '\'' +
                ", original_language='" + original_language + '\'' +
                '}';
    }
}
