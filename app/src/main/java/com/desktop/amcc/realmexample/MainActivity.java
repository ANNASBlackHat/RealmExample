package com.desktop.amcc.realmexample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.desktop.amcc.realmexample.entity.Movies;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Realm realm;
    private MovieListAdapter movieListAdapter;
    private List<Movies> moviesList;
    private FloatingActionButton fabAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = new ArrayList<>();
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        listView = (ListView) findViewById(R.id.list_view);

        RealmConfiguration configuration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(configuration);

        movieListAdapter = new MovieListAdapter(moviesList);
        listView.setAdapter(movieListAdapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMovieActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        RealmResults<Movies> movies = realm.where(Movies.class).findAll();
        moviesList.clear();
        moviesList.addAll(movies);
        movieListAdapter.notifyDataSetChanged();
    }
}
