package com.mycompany.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    /*
    The Android SDK provides several mock objects in the android.test.mock package.
    Some of these would be classified as stub or dummy types under stricter testing terms
    discussed in this chapter. The API includes mock objects for the types you see listed
    in this table. These Android types are often needed to be passed as parameters in a number
    of Android APIs, or used to get Android resources, such as databases, preferences, etc.
    The advantage of using these mock objects is that they come with the Android SDK.

    As these are provided by the SDK, simply use the API in your tests. The mock objects are made
    part of the test package along with test classes, instrumentation code and JUnit code when
    required. Calling a method on most of these mock objects causes an unsupported operation
    exception to be thrown. The mock objects are non-functional empty shells. You need to provide
    your implementation for methods your code exercises during testing. Remember, a mock object is
    a stand in, or place holder object for the real object.

    As such, they don't have all the same capability as a real object, but they have the interface,
    or behavior of the real object to act as if they do have the same capability. Use these Android
    mock objects when you need a stand in, not when you need the real capability. Implement just
    enough of the mock methods so as to fake out other objects that use them as if it was the real
    object. To demonstrate these Android mock objects, let's say we had a simple activity that
    contains a ListView. The ListView displays a list of strings, a collection of team names for
    example, and the names are going to be provided by a database cursor.
     */

    // Define ListView and CursorAdapter
    ListView teamList;
    TeamCursorAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the ListView
        teamList = (ListView) findViewById(R.id.teamList);

        // Call the updateList() method to update the ListView
        updateList();
    }

    // In the updateList() method, a database cursor is obtained from a TeamDatabase singleton
    // to create an instance of a cursor adapter. teamAdapter is then used to populate the ListView.
    private void updateList() {

        // Create an instance of TeamCursorAdapter, passing the context, and the Mock Cursor object
        teamAdapter = new TeamCursorAdapter(this, TeamDatabase.getInstance().getCursor(), 0);

        // If the adapter is not null ...
        if (teamAdapter != null) {

            // Set the adapter to the ListView
            teamList.setAdapter(teamAdapter);
        }
    }

}
