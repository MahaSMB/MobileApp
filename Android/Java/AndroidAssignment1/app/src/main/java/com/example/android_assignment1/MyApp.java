package com.example.android_assignment1;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {

    //ArrayList of strings for storing previous operations (for the advanced button)
    ArrayList<String> prevOperations;
    public int index = 0;

    public ArrayList<String> getPrevOperations() {
        if (prevOperations == null) {
            prevOperations = new ArrayList<String>(0);
        }
        return prevOperations;
    }
}
