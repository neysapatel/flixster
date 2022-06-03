package com.example.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class MovieDetailsActivity extends AppCompatActivity {

    // the movie to display
    Movie movie;
    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    ImageView tvImage;
    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // resolve the view objects
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        tvImage = (ImageView) findViewById(R.id.tvPoster);

        // unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // set the title and overview
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage / 2.0f);

        String imageURL = movie.getPosterPath();

        /*if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageURL = movie.getBackdropPath();
            String placeholder = "https://courses.codepath.org/course_files/metau_android/assets/flicks_backdrop_placeholder.png";
            Glide.with(context).load(placeholder).into(tvImage);
        } else {
            imageURL = movie.getPosterPath();
            String placeholder = "https://courses.codepath.org/course_files/metau_android/assets/flicks_movie_placeholder.png";
            Glide.with(context).load(placeholder).into(tvImage);
        }*/

       // Glide.with(context).load(imageURL).into(tvImage);
    }
}