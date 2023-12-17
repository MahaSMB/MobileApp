package com.example.assignment3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Question implements Parcelable {
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

    protected Question(Parcel in) {
        question = in.readString();
        answer = in.readByte() != 0;
        colour = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeByte((byte) (answer ? 1 : 0));
        dest.writeInt(colour);
    }
}
