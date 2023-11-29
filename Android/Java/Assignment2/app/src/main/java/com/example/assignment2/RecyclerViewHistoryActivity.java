package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHistoryActivity extends AppCompatActivity implements HistoryRecyclerAdapter.HistoryClickListener {

    RecyclerView rvHistoryList;
    ArrayList<History> historyList;
    HistoryRecyclerAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        historyList = ((MyApp)getApplication()).historyList;

        rvHistoryList = findViewById(R.id.rvHistoryList);
        adapter = new HistoryRecyclerAdapter(historyList, this);
        adapter.listener = this;
        rvHistoryList.setAdapter(adapter);
        rvHistoryList.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onHistoryClicked(int i) {
        Intent toHistoryDetailsIntent = new Intent(this, Manager.class);
        toHistoryDetailsIntent.putExtra("purchaseHistory", historyList);
        startActivity(toHistoryDetailsIntent);
    }
}
