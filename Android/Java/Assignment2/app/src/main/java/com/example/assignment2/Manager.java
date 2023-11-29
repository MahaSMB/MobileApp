package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Manager extends AppCompatActivity implements View.OnClickListener{

    Button buttonHistory;
    ArrayList<Product> currentStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        buttonHistory = findViewById(R.id.buttonHistory);

        buttonHistory.setOnClickListener(this);
        currentStock =  (ArrayList<Product>) getIntent().getSerializableExtra("purchaseHistory");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonHistory) {
            Intent toHistoryIntent = new Intent(Manager.this, HistoryList.class);
            currentStock = ((MyApp)getApplication()).store;
            toHistoryIntent.putExtra("purchaseHistory", currentStock);
            startActivity(toHistoryIntent);
        }

    }
}