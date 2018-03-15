package com.mycompany.example.myapplication;

import android.test.mock.MockCursor;

public class MockTeamCursor extends MockCursor {

    String[] teams = {"Cubs", "Cards", "Pirates", "Brewers", "Reds"};
    int row = 0;

    int mCurrentPosition = -1;

    @Override
    public int getCount() {
        return teams.length;
    }

    @Override
    public boolean moveToPosition(int position) {
        if (position >= 0 && position < teams.length) {
            mCurrentPosition = position;
            return true;
        }
        return false;
    }

    @Override
    public int getColumnIndexOrThrow(String columnName) {
        if (columnName.equals("_id"))
            return 0;
        else if (columnName.equals("name"))
            return 1;
        else throw new RuntimeException("column name" + columnName + "does not exist");
    }

    @Override
    public String getString(int columnIndex) {
        return teams[mCurrentPosition];
    }

    @Override
    public long getLong(int columnIndex) {
        return mCurrentPosition;
    }
}
