package com.desktop.amcc.realmexample.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ANNASBlackHat on 4/18/2016.
 */
public class Genre extends RealmObject {
    @PrimaryKey
    private int idGenre;
    private String genreName;

}
