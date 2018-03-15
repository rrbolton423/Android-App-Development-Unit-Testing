package com.mycompany.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked (View view){
        if (view.getId() == R.id.buttonAdd){
            // do some add work
            Log.d("ButtonClicked", "-------------------------------------------" + "adding");
        } else {
            // do the remove work
            Log.d("ButtonClicked", "-------------------------------------------" + "removing");
        }
    }

}
