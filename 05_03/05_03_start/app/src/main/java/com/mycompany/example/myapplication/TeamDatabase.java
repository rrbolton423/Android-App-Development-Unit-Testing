package com.mycompany.example.myapplication;

import android.database.Cursor;

public class TeamDatabase {

    // Eventually, the TeamDatabase cursor member variable, is set to the actual database
    // cursor. Unfortunately, the database has yet to be written by a fellow team member.
    // Even it it was, I'd want to test my Activity and the contained ListView independent
    // of the database. I can use a "MockCursor", one of the Mock types provided by the Android SDK as part of the
    // Android test mock package, to provide a stand in cursor for my app.

    // There are a lot of methods we can override from the MockCursor API.
    // In my case, I only need the MockCursor to supply data to the TeamCursorAdapter, so only
    // a fraction of these methods need to be implemented.

    // Define an instance of the Database and initially set it to null
    private static TeamDatabase instance = null;

    // Define a Cursor object for the Database to use
    Cursor cursor;

    // Empty constructor
    protected TeamDatabase(){
    }

    // Factory method that returns an single instance of the Database
    public static TeamDatabase getInstance(){

        // If the instance of the Database is null ...
        if (instance == null) {

            // Create the one and only instance of the Database
            instance = new TeamDatabase();
        }

        // Return the the one and only instance of the Database
        return instance;
    }

    // Get the assigned cursor of the Database
    public Cursor getCursor() {
        return cursor;
    }

    // Set the cursor on the Database
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
