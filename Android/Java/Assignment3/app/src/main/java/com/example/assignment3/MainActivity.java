package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
    int currentQuestionIndex, numberOfCorrectAnswers, progress, numberOfQuestionsInQuiz;
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
        numberOfQuestionsInQuiz = 10;

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

        if (currentQuestionIndex < numberOfQuestionsInQuiz) {
            //    // if question index ==10 in that case write result to file
            //    system and the variables should be reset in MyApp

            currentQuestionIndex++;
            // Update progress bar
            progress = (currentQuestionIndex * 100) / numberOfQuestionsInQuiz ;
            detProgressBar.setProgress(progress);
        }
        else {
            // display total, shuffle question array
            //    // inside click listener check whether index == 10, if ==10 shuffle the question
            //    //array again and question index set to 0 and repeat
            int score = numberOfCorrectAnswers / numberOfQuestionsInQuiz;
            ResultDialogFragment resultDialogFragment = ResultDialogFragment.newInstance(
                    getString(R.string.YourResultsAre, numberOfCorrectAnswers, numberOfQuestionsInQuiz),
                    numberOfCorrectAnswers);

            currentQuestionIndex = 0;
            numberOfCorrectAnswers = 0;
            progress = 0;
            listOfShuffledQuestions = questionBank.getQuestions(this);
            detProgressBar.setProgress(progress);
        }
        // add new question fragment
        addNewQuestionFragment();

    }

    public void addNewQuestionFragment() {

        // check and see if there's a fragment to remove
        QuestionFragment checkFragment = (QuestionFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (checkFragment != null) {
            // Remove the old fragment
            QuestionFragment oldFragment = new QuestionFragment();
            getSupportFragmentManager().beginTransaction().remove(checkFragment).commit();
        }

        // Add a new fragment
        QuestionFragment newQuestionFragment = QuestionFragment.newInstance(
                listOfShuffledQuestions.get(currentQuestionIndex).getQuestion(),
                listOfShuffledQuestions.get(currentQuestionIndex).getColour());
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,
                newQuestionFragment).commit();
    }
}