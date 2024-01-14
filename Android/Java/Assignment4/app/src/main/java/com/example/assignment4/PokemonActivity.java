package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity implements
        NetworkingManager.NetworkingInterfaceListener {

    // This page should portray details about one particular pokemon

    NetworkingManager networkingManager;
    JSONManager jsonManager;

    ArrayList<Pokemon> pokeList = new ArrayList<>(0);
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        networkingManager = ((MyApp)getApplication()).networkingManager;
        jsonManager = ((MyApp)getApplication()).jsonManager;
        networkingManager.listener = this;

        Pokemon capturedPokemon = getIntent().getExtras().getParcelable("pokemon");
        this.setTitle(capturedPokemon.pokeName.toString());
        //networkingManager.getPokemon();

        // wimage = findViewById(R.id.weathericon);
    }

    @Override
    public void networkingFinishWithJSONString(String json) {
//        pokeList = jsonManager.fromJSONtoArrayListOfPokemon(json);
//        // Get the rest of the details for this particular pokemon
//        ArrayList masterPokeList = ((MyApp)getApplication()).jsonManager.fromJSONtoArrayListOfPokemon(json);
//        networkingManager.getPokemon();
    }

    @Override
    public void networkingFinishWithBitmapImage(Bitmap bitmapPic) {
        // wimage.setImageBitmap(bitmap);
    }
}