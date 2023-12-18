package com.example.assignment3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AverageDialogFragment extends DialogFragment {

    interface saveAverage {
        void saveAverageAttemptsToFile(int averageScore, int numberOfAttempts);
    }

    saveAverage listener;

    static String msg = "";

    static int averageScore;
    static int numberOfAttempts;

    public static AverageDialogFragment newInstance(String message, int average, int attempts) {
        msg = message;
        averageScore = average;
        numberOfAttempts = attempts;
        return new AverageDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(msg)
                .setPositiveButton(getString(R.string.save_averages), (dialog, which) ->
                        listener.saveAverageAttemptsToFile(averageScore, numberOfAttempts))
                .setNegativeButton(getString(R.string.ignore_averages), (dialog, which) -> dismiss())
                .setTitle(R.string.averageDialogTitle)
                .create();
    }


}
