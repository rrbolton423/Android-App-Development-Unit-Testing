package com.mycompany.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

// Have the TeamCursorAdapter extend CursorAdapter
public class TeamCursorAdapter extends CursorAdapter {

    // Override constructor
    public TeamCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    // Override newView() method which populates the ListView with rows
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        // Return an inflated ListView row
        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
    }

    // Override bind View() method which populates individual vows in the ListView
    // with data content using the data from the cursor
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Get the current row in the ListView
        TextView team = (TextView) view.findViewById(android.R.id.text1);

        // Extract properties from the cursor, which is ultimately a Mock object
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));

         // Populate fields with extracted properties
        team.setText(name);
    }
}
