package com.example.assignment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {

    interface trueFalseClickListener{
        void trueButtonClicked();
        void falseButtonClick();
    }

    trueFalseClickListener listener;

    static String question;
    static int colour;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            question = getArguments().getString("question").toString();
            colour = getArguments().getInt("colour");
        }
    }

    public static QuestionFragment newInstance(String question, int colour) {
        Bundle bundle = new Bundle();
        bundle.putString("question", question);
        bundle.putInt("colour", colour);

        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(bundle);

        return fragment;

        /*
        https://stackoverflow.com/questions/9245408/best-practice-for-instantiating-a-new-android-fragment
         */
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);

       View view = inflater.inflate(R.layout.fragment, container, false);
       TextView textViewQuestion = view.findViewById(R.id.textViewQuestion);

       textViewQuestion.setText(question);
       textViewQuestion.setBackgroundResource(colour);



       return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
