package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity implements
        PokemonInfoFetcher.infoFetchListener {

    // This page should portray details about one particular pokemon after clicking from
    // Main Activity
    PokemonInfoFetcher pokemonInfoFetcher;
    JSONManager jsonManager;

    ArrayList<Pokemon> pokeList = new ArrayList<>(0);
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    TextView tvDetailsPokeID, tvDetailsPokeName, tvDPokeName, tvDpokeID,  tvDHeight,  tvDWeight;
    ImageView ivDetailsPokeProfile;

    //TableLayout tvDTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        tvDetailsPokeID = findViewById(R.id.tvDetailsPokeID);
        tvDetailsPokeName = findViewById(R.id.tvDetailsPokeName);
        ivDetailsPokeProfile = findViewById(R.id.ivDetailsPokeProfile);

        tvDPokeName = findViewById(R.id.tvDPokeName);
        tvDpokeID = findViewById(R.id.tvDpokeID);
        tvDHeight = findViewById(R.id.tvDHeight);
        tvDWeight = findViewById(R.id.tvDWeight);

        jsonManager = ((MyApp)getApplication()).jsonManager;
        //masterPokeList = ((MyApp)getApplication()).masterPokeList;

        Pokemon capturedPokemon = getIntent().getExtras().getParcelable("pokemon");
        this.setTitle(capturedPokemon.getPokeName());

        String spriteURL =  capturedPokemon.getPokeProfile();
        pokemonInfoFetcher = MyApp.pokemonInfoFetcherRecView;

        tvDetailsPokeID.setText( String.valueOf( capturedPokemon.getPokeID()));
        tvDetailsPokeName.setText(capturedPokemon.getPokeName());
        //tvDPokeName.setText(capturedPokemon.getPokeName());

        // Table Values
        tvDPokeName.setText( capturedPokemon.getPokeName());
        tvDpokeID.setText(String.valueOf(capturedPokemon.getPokeID()));
        tvDHeight.setText(String.valueOf(capturedPokemon.getHeight()));
        tvDWeight.setText(String.valueOf(capturedPokemon.getWeight()));

        // To Display the Pokemon Sprite
        Glide.with(this)
                .load(spriteURL)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.pokeball_background) //placeholder image
                        .error(R.drawable.error_image_foreground)  //error image in case of a loading error
                )
                .into(ivDetailsPokeProfile);
    }

    @Override
    public void infoFetchPokemonJSONObj(String result) {

    }

}