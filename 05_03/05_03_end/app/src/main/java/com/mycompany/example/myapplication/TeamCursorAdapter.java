package com.mycompany.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TeamCursorAdapter extends CursorAdapter {

    public TeamCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView team = (TextView) view.findViewById(android.R.id.text1);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
         // Populate fields with extracted properties
        team.setText(name);
    }
}
