package com.example.assignment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryList extends AppCompatActivity {

    ArrayList<Product> currentStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        currentStock =  (ArrayList<Product>) getIntent().getSerializableExtra("purchaseHistory");

    }


}