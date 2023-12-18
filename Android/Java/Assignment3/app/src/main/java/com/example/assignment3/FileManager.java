package com.example.assignment3;

import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    String fileName = "savedResults.txt";

    public void writeResultsToFile(Context context, int numberOfCorrectAnswers, int numberOfQuestionsInQuiz) {

        String score = numberOfCorrectAnswers + " / " + numberOfQuestionsInQuiz;

        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_APPEND);
            fileOutputStream.write((score + "\r\n").getBytes());
            Log.d("Writing to File", "Saving results");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAverageScoreAndAttemptsToFile(Context context, double averageScore,  double numberOfAttempts) {

        String averageAndAttempt = "Average: " + averageScore + " in " + numberOfAttempts + " attempts.";

        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_APPEND);
            fileOutputStream.write((averageAndAttempt + "\r\n").getBytes());
            Log.d("Writing to File", "Saving average and attempts");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
