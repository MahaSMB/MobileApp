package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvPokemonName, tvPokemonID;
    ImageView ivPokemonProfile;

    ListView listviewPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviewPokemon = findViewById(R.id.listviewPokemon);
    }



    @Override
    public void onClick(View v) {

    }
}