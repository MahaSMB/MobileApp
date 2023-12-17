package com.example.assignment3;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class MyApp extends Application {
    ArrayList<Question> questionsList = new ArrayList<>(10);


    int QuestionIndex;
    int numberOfCorrectAnswers; // number of correct answers should be incremented and divided by total (in main activity) in file sys
}
