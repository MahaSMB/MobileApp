package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Manager extends AppCompatActivity implements View.OnClickListener{

    Button buttonHistory;
    ArrayList<History> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        buttonHistory = findViewById(R.id.buttonHistory);

        buttonHistory.setOnClickListener(this);
        historyList =  (ArrayList<History>) getIntent().getSerializableExtra("purchaseHistory");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // Button to History List (Recycler View)
        if (id == R.id.buttonHistory) {
            Intent toHistoryListIntent = new Intent(Manager.this, RecyclerViewHistoryActivity.class);
//            historyList = ((MyApp)getApplication()).historyList;
//            toHistoryIntent.putExtra("purchaseHistory", historyList);
            startActivity(toHistoryListIntent);
        }

    }
}