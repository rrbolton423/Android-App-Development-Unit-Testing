package com.mycompany.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView teamList;
    TeamCursorAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamList = (ListView) findViewById(R.id.teamList);
        updateList();
    }

    private void updateList() {
        teamAdapter = new TeamCursorAdapter(this, TeamDatabase.getInstance().getCursor(), 0);
        if (teamAdapter != null) {
            teamList.setAdapter(teamAdapter);
        }
    }

}
