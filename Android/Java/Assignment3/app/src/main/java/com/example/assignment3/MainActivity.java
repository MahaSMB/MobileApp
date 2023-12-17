package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Context context;
    FrameLayout frameLayout;
    Button buttonTrue, buttonFalse;
    QuestionBank questionBank = new QuestionBank();
    String currentQuestion;
    int currentColour = 1;
    ProgressBar detProgressBar;

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


//        buttonTrue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addNewQuestionFragment();
//    // make a single click listener for both true and false buttons
//    // inside click listener check whether index == 10, if ==10 shuffle the question array again and question index set to 0 and repeat
//    // if question index ==10 in that case write result to file system and the variables should be reset in MyApp
//            }
//        });


    }

    public void addNewQuestionFragment() {
        QuestionFragment newQuestionFragment = QuestionFragment.newInstance(currentQuestion, currentColour);
        //QuestionFragment newQuestionFragment = QuestionFragment.newInstance(, currentColour);
        QuestionFragment checkFragment = (QuestionFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (checkFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(checkFragment).commit();
        }
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, newQuestionFragment).commit();
    }

    @Override
    public void onClick(View v) {

    }
}