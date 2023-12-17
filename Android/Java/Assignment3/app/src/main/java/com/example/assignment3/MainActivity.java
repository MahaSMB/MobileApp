package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout frameLayout;
    Button buttonTrue, buttonFalse;
    QuestionBank questionBank = new QuestionBank();
    int currentQuestionIndex, numberOfCorrectAnswers;
    ProgressBar detProgressBar;

    ArrayList<Question> listOfShuffledQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        detProgressBar = findViewById(R.id.detProgressBar);
        frameLayout = findViewById(R.id.frameLayout);

        buttonTrue.setOnClickListener(this);
        buttonFalse.setOnClickListener(this);

        currentQuestionIndex = 0;
        numberOfCorrectAnswers = 0;

        listOfShuffledQuestions = questionBank.getQuestions(this);
        addNewQuestionFragment();

    }

//    public void addNewQuestion(String question, boolean answer) {
//        questionBank.addNewQuestion(question, answer);
//        // add number of questions to display
//
//    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.buttonTrue) {
            if (listOfShuffledQuestions.get(currentQuestionIndex).isAnswer()) {
                // If the user got the answer right
                Toast.makeText(this, getString(R.string.correctAnswer), Toast.LENGTH_LONG).show();
                numberOfCorrectAnswers++;
            }
            else {
                // If the user got the answer wrong
                Toast.makeText(this, getString(R.string.incorrectAnswer), Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonFalse) {
            if (!listOfShuffledQuestions.get(currentQuestionIndex).isAnswer()) {
                // If the user got the answer right
                Toast.makeText(this, getString(R.string.correctAnswer), Toast.LENGTH_LONG).show();
                numberOfCorrectAnswers++;
            }
            else {
                // If the user got the answer wrong
                Toast.makeText(this, getString(R.string.incorrectAnswer), Toast.LENGTH_LONG).show();
            }
        }

        if (currentQuestionIndex < 10) {
            //    // if question index ==10 in that case write result to file
            //    system and the variables should be reset in MyApp

            currentQuestionIndex++;
        }
        else {
            // display total, shuffle question array
            //    // inside click listener check whether index == 10, if ==10 shuffle the question
            //    //array again and question index set to 0 and repeat

            currentQuestionIndex = 0;
            numberOfCorrectAnswers = 0;
            listOfShuffledQuestions = questionBank.getQuestions(this);
        }
        // add new question fragment
        addNewQuestionFragment();

    }

    public void addNewQuestionFragment() {
        QuestionFragment newQuestionFragment = QuestionFragment.newInstance(
                listOfShuffledQuestions.get(currentQuestionIndex).getQuestion(),
                listOfShuffledQuestions.get(currentQuestionIndex).getColour());
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,
                newQuestionFragment).commit();
    }
}