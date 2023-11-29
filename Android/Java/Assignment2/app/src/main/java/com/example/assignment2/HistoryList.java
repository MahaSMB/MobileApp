package com.example.assignment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryList extends AppCompatActivity {

    ArrayList<History> historyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        historyList =  (ArrayList<History>) getIntent().getSerializableExtra("purchaseHistory");

    }


}