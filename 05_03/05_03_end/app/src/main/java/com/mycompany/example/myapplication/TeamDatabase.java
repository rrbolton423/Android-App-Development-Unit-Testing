package com.mycompany.example.myapplication;

import android.database.Cursor;

public class TeamDatabase {

    private static TeamDatabase instance = null;
    Cursor cursor;

    protected TeamDatabase(){
    }

    public static TeamDatabase getInstance(){
        if (instance == null) {
            instance = new TeamDatabase();
        }
        return instance;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
