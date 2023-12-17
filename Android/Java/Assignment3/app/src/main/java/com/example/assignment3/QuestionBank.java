package com.example.assignment3;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionBank {

    ArrayList<Integer> colours;
    public ArrayList<Integer> getColours(Context context) {
        if (colours == null) {

            colours = new ArrayList<>(10);

            colours.add(context.getColor(R.color.Blue));
            colours.add(context.getColor(R.color.ArmyBrown));
            colours.add(context.getColor(R.color.green));
            colours.add(context.getColor(R.color.red));
            colours.add(context.getColor(R.color.yellow));
            colours.add(context.getColor(R.color.whitesmoke));
            colours.add(context.getColor(R.color.mediumpurple));
            colours.add(context.getColor(R.color.Celeste));
            colours.add(context.getColor(R.color.pink));
            colours.add(context.getColor(R.color.khaki));
        }
        return colours;
    }

    public QuestionBank() {

    }

    ArrayList<Question> questionsList;
    public ArrayList<Question> getQuestions(Context context) {
        if (questionsList == null) {
            questionsList = new ArrayList<>(10);
            ArrayList<Integer> listOfColours = getColours(context);
            Collections.shuffle(listOfColours);
            questionsList.add(new Question(context.getResources().getString(R.string.question1), false, listOfColours.get(0)));
            questionsList.add(new Question(context.getResources().getString(R.string.question2), true, listOfColours.get(1)));
            questionsList.add(new Question(context.getResources().getString(R.string.question3), false, listOfColours.get(2)));
            questionsList.add(new Question(context.getResources().getString(R.string.question4), true, listOfColours.get(3)));
            questionsList.add(new Question(context.getResources().getString(R.string.question5), true, listOfColours.get(4)));
            questionsList.add(new Question(context.getResources().getString(R.string.question6), true, listOfColours.get(5)));
            questionsList.add(new Question(context.getResources().getString(R.string.question7), true, listOfColours.get(6)));
            questionsList.add(new Question(context.getResources().getString(R.string.question8), false, listOfColours.get(7)));
            questionsList.add(new Question(context.getResources().getString(R.string.question9), true, listOfColours.get(8)));
            questionsList.add(new Question(context.getResources().getString(R.string.question10), false, listOfColours.get(9)));
        }
        Collections.shuffle(questionsList);
        return questionsList;
    }

    public void addNewQuestion(String question, boolean answer) {
        Question questionObject = new Question(question, answer, getRandomColourIndex());
        this.questionsList.add(questionObject);
    }

    private int getRandomColourIndex() {
        int randomColour = (int)(Math.random() * 10 );
        return colours.get(randomColour);
    }

}
