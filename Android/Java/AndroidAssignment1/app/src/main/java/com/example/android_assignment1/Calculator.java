package com.example.android_assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    int firstNumber = 0, secondNumber = 0, result = 0;
    char operator;
    boolean operatorFound = false, numberFound = false, operatorError = false, numberError = false;

    String answerLine = "";


    // Number buttons
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0 ;

    // Operator buttons
    Button buttonMultiply, buttonMinus, buttonPlus, buttonDivide;

    // Action buttons
    Button buttonEquals, buttonClear, buttonAdvanced;

    // TextView
    TextView answerLineTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonEquals = findViewById(R.id.buttonEquals);
        buttonClear = findViewById(R.id.buttonClear);
        buttonAdvanced = findViewById(R.id.buttonAdvanced);

        answerLineTextView = findViewById(R.id.answerLineTextView);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonMultiply.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

        buttonEquals.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonAdvanced.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int answerLength = answerLineTextView.length();
        if (id == R.id.button1) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("1");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.button2) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("2");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button3) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("3");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button4) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("4");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button5) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("5");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button6) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("6");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button7) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("7");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button8) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("8");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button9) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("9");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }        }
        else if (id == R.id.button0) {
            if (answerLength == 0 || !Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("0");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneDigit, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonMultiply) {
            if (answerLength == 1 || Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("*");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneOperator, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonDivide) {
            if (answerLength == 1 || Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("/");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneOperator, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonPlus) {
            if (answerLength == 1 || Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("+");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneOperator, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonMinus) {
            if (answerLength == 1 || Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                answerLineTextView.append("-");
            }
            else {
                Toast.makeText(this, R.string.alertMessageOneOperator, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonEquals) {
            if (answerLength == 3 || Character.isDigit(answerLineTextView.getText().charAt(answerLength - 1))) {
                calculate();
            }
            else {
                //Toast.makeText(this, R.string.alertMessageOneOperator, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonClear) {
            clearAnswerLine();
        }
        else if (id == R.id.buttonAdvanced) {
            //
        }
        else {
            // do nothing
        }
    }

    /* TO DO
    // Think about turning answer string into ArrayList
    // Have answer string/ArrayList in a MyApp class to have persistent data
    // Make sure layout is good in landscape mode (make a new XML file)
    // icon

     */

    void push (String text) {
        answerLine += text;
    }

    int calculate(){
        char[] chars = answerLine.toCharArray();
        return 0;
    }
//
//    void getResult() {
//
//    }
//
    void clearAnswerLine() {
        answerLineTextView.setText("");
    }
//
//    void showHistory() {
//
//    }
}
