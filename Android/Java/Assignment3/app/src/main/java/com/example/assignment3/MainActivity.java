package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ResultDialogFragment.saveResult, AverageDialogFragment.saveAverage {

    FrameLayout frameLayout;
    Button buttonTrue, buttonFalse;
    QuestionBank questionBank = new QuestionBank();
    int currentQuestionIndex, numberOfCorrectAnswers, progress, numberOfQuestionsInQuiz;
    int averageScore, numberOfAttempts;
    ProgressBar detProgressBar;

    ArrayList<Question> listOfShuffledQuestions = new ArrayList<>();
    ArrayList<Integer> listOfCorrectAnswers = new ArrayList<>();

    FileManager fileManager = new FileManager();

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

        fileManager = ((MyApp)getApplication()).fileManager;

        ((MyApp)getApplication()).numberOfCorrectAnswers = numberOfCorrectAnswers;

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
        if (currentQuestionIndex < numberOfQuestionsInQuiz - 1) {
            // If question index is less than number of questions in quiz:
            // - write to file
            // - Increase question index
            // - update progress bar
            // otherwise system and variables should be reset in MyApp

            currentQuestionIndex++;
            // Update progress bar
            progress = (currentQuestionIndex * 100) / numberOfQuestionsInQuiz ;
            detProgressBar.setProgress(progress);
        }
        else { // User has reached the last question
            int score = numberOfCorrectAnswers / numberOfQuestionsInQuiz;

            // Create the Alert dialogue
            // Set the string, feed the score (number of correct answers / number of questions in quiz )
            ResultDialogFragment resultDialogFragment = ResultDialogFragment.newInstance(
                    getString(R.string.YourResultsAre, numberOfCorrectAnswers, numberOfQuestionsInQuiz),
                    numberOfCorrectAnswers, numberOfQuestionsInQuiz);

            // Set the context for the listener
            resultDialogFragment.listener = this;
            // Show the score in the alert dialogue with title 'Results'
            resultDialogFragment.show(getSupportFragmentManager(), "Results");

            // Reset values now that I've reached the last question
            listOfCorrectAnswers.add(numberOfCorrectAnswers); // saving to add to the average
            currentQuestionIndex = 0;
            numberOfCorrectAnswers = 0;
            progress = 0;

            // Shuffle the questions
            listOfShuffledQuestions = questionBank.getQuestions(this);

            // Reset the progress bar to the above value of 0
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

    @Override
    public void saveNumberOfCorrectAnswersToFile(int numberOfCorrectAnswers, int numberOfQuestionsInQuiz) {
        fileManager.writeResultsToFile(MainActivity.this, numberOfCorrectAnswers,
                numberOfQuestionsInQuiz);

        //((MyApp)getApplication()).fileManager = fileManager;

        Toast.makeText(MainActivity.this, getString(R.string.resultsAreSaved), Toast.LENGTH_SHORT).show();
    }

    public double[] getAverage(ArrayList<Integer> listOfCorrectAnswers, int numberOfQuestionsInQuiz) {
        int total = 0;
        for (int CorrectAnswers:listOfCorrectAnswers) {
            total =+ CorrectAnswers;
        }

        int numberOfAttempts = listOfCorrectAnswers.size();

        double mean = total / numberOfQuestionsInQuiz;
        DecimalFormat df = new DecimalFormat("0.00" );
        mean = Double.parseDouble(df.format(mean));

        double[] averageAndAttempt = {mean, numberOfAttempts};

        return averageAndAttempt;
    }

    public void getChosenNumberOfQuestions() {

    }

    public void resetSavedResults() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.getAverage_menu:
                getAverage(listOfCorrectAnswers, numberOfQuestionsInQuiz);
                // Show alert dialogue
                return true;
            case R.id.chooseNumberOfQuestions_menu:
                getChosenNumberOfQuestions();
                return true;
            case R.id.resetSavedResults_menu:
                resetSavedResults();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void saveAverageAttemptsToFile(int averageScore, int numberOfAttempts) {
        fileManager.writeAverageScoreAndAttemptsToFile(MainActivity.this, averageScore, numberOfAttempts);

        //((MyApp)getApplication()).fileManager = fileManager;

        Toast.makeText(MainActivity.this, getString(R.string.resultsAreSaved), Toast.LENGTH_SHORT).show();
    }


}