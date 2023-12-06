package com.example.assignment3;

public class Question {
    String question;
    boolean answer;
    String colour;

    public Question() {
    }

    public Question(String question, boolean answer, String colour) {
        this.question = question;
        this.answer = answer;
        this.colour = colour;
    }

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }


}
