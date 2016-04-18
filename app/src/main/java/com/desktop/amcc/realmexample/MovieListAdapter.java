package com.desktop.amcc.realmexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.desktop.amcc.realmexample.entity.Movies;

import java.util.List;

/**
 * Created by ANNASBlackHat on 4/18/2016.
 */
public class MovieListAdapter extends BaseAdapter {

    private List<Movies> movies;

    public MovieListAdapter(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movies, parent, false);
        TextView txtJudul = (TextView) v.findViewById(R.id.title);
        TextView txtDate = (TextView) v.findViewById(R.id.release_date);
        TextView txtRuntime = (TextView) v.findViewById(R.id.runtime);

        txtJudul.setText(movies.get(position).getMovieTitle());
        txtDate.setText(movies.get(position).getReleaseDate());
        txtRuntime.setText(String.valueOf(movies.get(position).getRuntime())+" Minutes");
        return v;
    }
}
