package com.example.android_assignment1;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
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
    boolean validEqualSignEntered = false, validValue = false;

    String answerLine = "";
    //char[] answerLineChars = null;

    // Number buttons
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0 ;

    // Operator buttons
    Button buttonMultiply, buttonMinus, buttonPlus, buttonDivide;

    // Action buttons
    Button buttonEquals, buttonClear, buttonAdvanced;
    boolean advancedButtonEnabled = false;
    ArrayList<String> listOfOperations;
    int index = 0;

    // TextView
    TextView answerLineTextView, textViewHistory;
    //Configuration newConfig2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.firstactivity);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape_layout);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.firstactivity);
        }

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
        textViewHistory = findViewById(R.id.textViewHistory);
        textViewHistory.setVisibility(View.INVISIBLE);

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
            answerLineTextView.append("1");
        }
        else if (id == R.id.button2) {
            answerLineTextView.append("2");
        }
        else if (id == R.id.button3) {
            answerLineTextView.append("3");
        }
        else if (id == R.id.button4) {
            answerLineTextView.append("4");
        }
        else if (id == R.id.button5) {
            answerLineTextView.append("5");
        }
        else if (id == R.id.button6) {
            answerLineTextView.append("6");
        }
        else if (id == R.id.button7) {
            answerLineTextView.append("7");
        }
        else if (id == R.id.button8) {
            answerLineTextView.append("8");
        }
        else if (id == R.id.button9) {
            answerLineTextView.append("9");
        }
        else if (id == R.id.button0) {
            answerLineTextView.append("0");
        }
        else if (id == R.id.buttonMultiply) {
            answerLineTextView.append("*");
        }
        else if (id == R.id.buttonDivide) {
            answerLineTextView.append("/");
        }
        else if (id == R.id.buttonPlus) {
            answerLineTextView.append("+");
        }
        else if (id == R.id.buttonMinus) {
            answerLineTextView.append("-");
        }
        else if (id == R.id.buttonEquals) {
            //answerLineTextView.append("=");
            push(answerLineTextView.getText().toString()); // push user's entered value
            if (numberError || operatorError) {
                Toast.makeText(this, R.string.alertMessageValidationFailedEnterNewValue, Toast.LENGTH_LONG).show();
                clearAnswerLine();
            }
            else {
                result = calculate();

                String calculations = answerLineTextView.getText().toString() + "=" + String.valueOf(result);
                answerLineTextView.setText(calculations);
                // push previous line into string to save into ArrayList of strings
                ((MyApp)getApplication()).getPrevOperations().add(calculations);

                if (advancedButtonEnabled) {
                    //((MyApp)getApplication()).getPrevOperations().add(answerLine);
                    listOfOperations = ((MyApp)getApplication()).getPrevOperations();
                    index = ((MyApp)getApplication()).index;
                    textViewHistory.append(calculations + "\n");
                }
            }
        }
        else if (id == R.id.buttonClear) {
            clearAnswerLine();
        }
        else if (id == R.id.buttonAdvanced) {
            if (advancedButtonEnabled) {
                advancedButtonEnabled = false;
                buttonAdvanced.setText(R.string.advanced);
                hideHistory();
            }
            else {
                advancedButtonEnabled = true;
                buttonAdvanced.setText(R.string.standard_no_history);
                showHistory();
            }
        }
        else {
            Toast.makeText(this, R.string.alertMessageUnknownError, Toast.LENGTH_LONG).show();
        }

    }

    /* TO DO
    // Think about turning answer string into ArrayList (skip)
    // Have answer string/ArrayList in a MyApp class to have global data
    // Make sure layout is good in landscape mode (make a new XML file) (done)
    // icon (done)

     */

    void push (String text) {
        answerLine += text;
        validate(answerLine);
    }

    void validate (String answerLine) {
        // Make sure the entered line to calculate is valid
        char[] chars = answerLine.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            // Starting from the first character, for every second character, make sure the
            // character is a digit and that every other character is not a digit
            if (Character.isDigit(chars[i]) || !Character.isDigit(chars[i + 1])) {
                // This is a valid string so far. We accept the input and thus do nothing.
                numberError = false;
                operatorError = false;
            }
            else {
                numberError = true; // Set to true if the above case is FALSE as it's not a valid string
                operatorError = true;
                Toast.makeText(this, R.string.alertMessageValidationFailedNumberOrOperatorError, Toast.LENGTH_LONG).show();
            }
        }
        for(int i = 0; i < chars.length; i++) {
            // Starting from the first character, search for an operator
            if (!Character.isDigit(chars[i])) { // Every operator will be at an odd-numbered index
                switch (chars[i]) {
                    case '*':
                    case '/':
                    case '+':
                    case '-':
                        operatorFound = true;
                        operator = chars[i];
                        break;
                    case '=':
                        if (i > 2) {
                            // Every equal sign will be at an odd-numbered index and at least and index of 3
                            validEqualSignEntered = true;
                            validValue = true;
                        }
                        else {
                            //equal sign is not valid
                            Toast.makeText(this, R.string.alertMessageEqualSignInvalidPosition, Toast.LENGTH_LONG).show();
                            //clearAnswerLine();
                        }
                        break;
                    default:
                        // nonDigit character is not an operator
                        operatorError = true;
                        Toast.makeText(this, R.string.alertMessageNonDigitCharacterNotOperator, Toast.LENGTH_LONG).show();
                        //clearAnswerLine();
                        break;
                }
            }
            else if (Character.isDigit(chars[i])) {
                numberFound = true;
            }
            else {
                //operatorError = true;
                operatorFound = false;
            }
        }
    }
    int calculate(){
        char[] chars = answerLine.toCharArray();
        if(Character.isDigit(chars[0]) && !numberError ) {
            firstNumber = Integer.parseInt(String.valueOf(chars[0]));
            //operator = chars[1];
        }
        for (int i = 2; i < chars.length; i += 2) {
            if(Character.isDigit(chars[i])) {
                if (i > 2) {
                    firstNumber = result;
                    secondNumber = Integer.parseInt(String.valueOf(chars[i]));
                    operator = chars[i - 1];
                    numberFound = true;
                }
                else { // when i == 2
                    secondNumber = Integer.parseInt(String.valueOf(chars[i]));
                    operator = chars[i - 1];
                    numberFound = true;
                }
            }
            else if (!Character.isDigit(chars[i - 1])){ /* not needed. delete */
                operator = chars[i - 1];
                operatorFound = true;
            }
            else if (!Character.isDigit(chars[i]) && chars[i] == ('=')){ /* not needed. delete */
                operator = chars[i];
                operatorFound = true;
            }
            else {
                Toast.makeText(this, R.string.alertMessageNonDigitCharacterNotOperator, Toast.LENGTH_LONG).show();
                clearAnswerLine();
                return -2;
            }
            switch (operator) {
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber == 0) {
                        numberError = true;
                        Toast.makeText(this, R.string.alertMessageDivisionByZero, Toast.LENGTH_LONG).show();
                        clearAnswerLine();
                        return -1;
                    }
                    else {
                        result = firstNumber / secondNumber;
                    }
                    break;
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '=':
                    return result;
                default:
                    break;
            }
        }
        if (numberError || operatorError) {
            Toast.makeText(this, R.string.alertMessageNumberOrOperatorError, Toast.LENGTH_LONG).show();
            clearAnswerLine();
            return -4;
        }
        else {
            //Toast.makeText(this, R.string.alertMessageUnknownError, Toast.LENGTH_LONG).show();
            return result;
        }

    }
//
//    void getResult() {
//
//    }
//
    void clearAnswerLine() {
        answerLineTextView.setText("");
        answerLine = "";
        result = 0;
    }

    void showHistory() {
        textViewHistory.setVisibility(View.VISIBLE);
    }

    void hideHistory() {
        textViewHistory.setVisibility(View.INVISIBLE);
    }
}
