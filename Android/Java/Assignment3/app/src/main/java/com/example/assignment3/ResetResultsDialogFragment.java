package com.example.assignment3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ResetResultsDialogFragment extends DialogFragment {


    interface resetResults {
        void resetSavedResults();
    }

    resetResults listener;

    static String msg = "";

    public static ResetResultsDialogFragment newInstance(String message) {
        msg = message;
        return new ResetResultsDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(msg)
                .setPositiveButton(getString(R.string.delete_results), (dialog, which) ->
                        listener.resetSavedResults())
                .setNegativeButton(getString(R.string.ignore_results), (dialog, which) -> dismiss())
                .setTitle(R.string.resetDialogTitle)
                .create();
    }


}