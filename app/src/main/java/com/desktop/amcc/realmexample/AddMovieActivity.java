package com.desktop.amcc.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.desktop.amcc.realmexample.entity.Movies;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddMovieActivity extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtRuntime;
    private EditText edtDate;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        edtTitle = (EditText) findViewById(R.id.title);
        edtRuntime = (EditText) findViewById(R.id.runtime);
        edtDate = (EditText) findViewById(R.id.release_date);

        RealmConfiguration configuration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(configuration);
    }

    private void save(){
        realm.beginTransaction();
        Movies movies = realm.createObject(Movies.class);
        movies.setIdMovie(generateID());
        movies.setMovieTitle(edtTitle.getText().toString());
        movies.setReleaseDate(edtDate.getText().toString());
        movies.setRuntime(Integer.parseInt(edtRuntime.getText().toString()));
        realm.commitTransaction();
        finish();
    }

    private int generateID(){
        try {
            return realm.where(Movies.class).max("idMovie").intValue()+1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_save){
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
