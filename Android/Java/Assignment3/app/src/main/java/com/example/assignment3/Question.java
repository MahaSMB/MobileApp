package com.example.assignment3;

public class Question {
    String question;
    boolean answer;

    int colour;
    public Question() {
    }

    public Question(String question, boolean answer, int colour) {
        this.question = question;
        this.answer = answer;
        this.colour = colour;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
