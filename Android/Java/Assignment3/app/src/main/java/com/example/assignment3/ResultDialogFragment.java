package com.example.assignment3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ResultDialogFragment extends DialogFragment {

    interface saveResult {
        void saveResult(int number);
    }

    saveResult listener;

    static String msg = "";
    static int savedNumber;

    public static ResultDialogFragment newInstance(String message, int number) {
        msg = message;
        savedNumber = number;
        return new ResultDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(msg)
                .setPositiveButton(getString(R.string.save_results), (dialog, which) -> listener.saveResult(savedNumber))
                .setNegativeButton(getString(R.string.ignore_results), (dialog, which) -> dismiss())
                .create();
    }


}
