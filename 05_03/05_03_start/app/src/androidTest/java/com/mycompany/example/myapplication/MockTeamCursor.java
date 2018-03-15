package com.mycompany.example.myapplication;

import android.test.mock.MockCursor;

/**
 * Created by romellbolton on 3/13/18.
 */

// I create a MockTeamCursor class in the Android test folder, as I'm going to write
// an instrumented test using Espresso, and I want the mock to be available to
// the instrumented test.

// I make my Cursor class extend MockCursor
public class MockTeamCursor extends MockCursor {

    // I create an array of names that I want to serve as the fake data provided by my fake cursor.
    String[] teams = {"Cubs", "Cards", "Pirates", "Brewers", "Reds"};

    // I also create a couple of instance variable that I use throughout my class.
    int row = 0;
    int mCurrentPosition = -1;

    /*
    Override enough Cursor methods to make the MockCursor object work to fake out the rest
    of the Android code using it, i.e the Adapter
     */

    // getCount() returns the numbers of rows in the cursor.
    @Override
    public int getCount() {
        return teams.length;
    }

    // moveToPosition() moves the cursor to an absolute position.
    // The valid range of values is -1 <= position <= count.
    @Override
    public boolean moveToPosition(int position) {
        if (position >= 0 && position < teams.length) {
            mCurrentPosition = position;
            return true;
        }
        return false;
    }

    // getColumnIndexOrThrow returns the zero-based index for the given column name,
    // or throws IllegalArgumentException if the column doesn't exist.
    @Override
    public int getColumnIndexOrThrow(String columnName) {
        if (columnName.equals("_id"))
            return 0;
        else if (columnName.equals("name"))
            return 1;
        else throw new RuntimeException("column name " + columnName + " does not exist");
    }

    // getString() returns the value of the requested column as a String.
    @Override
    public String getString(int columnIndex) {
        return teams[mCurrentPosition];
    }

    // getLong() returns the value of the requested column as a long.
    @Override
    public long getLong(int columnIndex) {
        return mCurrentPosition;
    }

    // Then I override the methods of MockCursor that I know the TeamCursorAdapter will
    // call on to get the data when the ListView is being displayed. This included getCount(),
    // moveToPosition(), getColumnIndexOrThrow(), getString() and getLong(). Just enough
    // code to get by, and make the TeamCursorAdapter think it's talking to the real cursor.
}
