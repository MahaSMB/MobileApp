package com.example.assignment3;

import android.content.Context;
import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionBank extends Question {


    public QuestionBank() {

    }

    ArrayList<Question> questionsList = new ArrayList<>(10);


    public ArrayList<Question> getQuestions(Context context) {
        if (questionsList == null) {
            questionsList = new ArrayList<>(10);
            questionsList.add(new Question(context.getResources().getString(R.string.question1), false, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question2), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question3), false, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question4), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question5), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question6), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question7), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question8), false, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question9), true, colour));
            questionsList.add(new Question(context.getResources().getString(R.string.question10), false, colour));
        }
        return questionsList;
    }


}
