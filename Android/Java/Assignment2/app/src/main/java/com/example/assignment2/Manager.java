package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manager extends AppCompatActivity implements View.OnClickListener{

    Button buttonHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        buttonHistory = findViewById(R.id.buttonHistory);

        buttonHistory.setOnClickListener(this);
        getIntent().getSerializableExtra("purchaseHistory");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonHistory) {

        }

    }
}