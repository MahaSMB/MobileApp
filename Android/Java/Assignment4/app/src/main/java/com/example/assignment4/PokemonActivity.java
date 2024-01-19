package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class PokemonActivity extends AppCompatActivity implements
        PokemonInfoFetcher.infoFetchListener, DatabaseManager.DatabaseManagerInterfaceListener,
        View.OnClickListener {

    // This page should portray details about one particular pokemon after clicking from
    // Main Activity

    Button matingButton;
    PokemonInfoFetcher pokemonInfoFetcher;

    Pokemon capturedPokemon;

    DatabaseManager databaseManager;

    JSONManager jsonManager;

    ArrayList<Pokemon> pokeList = new ArrayList<>(0);
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    TextView tvDetailsPokeName, tvDPokeName, tvDpokeID, tvDHeight, tvDWeight, tvDspecies;
    ImageView ivDetailsPokeProfile;

    //TableLayout tvDTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        tvDetailsPokeName = findViewById(R.id.tvDetailsPokeName);
        ivDetailsPokeProfile = findViewById(R.id.ivDetailsPokeProfile);
        matingButton = findViewById(R.id.matingButton);
        matingButton.setOnClickListener(this);

        tvDPokeName = findViewById(R.id.tvDPokeName);
        tvDpokeID = findViewById(R.id.tvDpokeID);
        tvDHeight = findViewById(R.id.tvDHeight);
        tvDWeight = findViewById(R.id.tvDWeight);
        tvDspecies = findViewById(R.id.tvDspecies);

        jsonManager = ((MyApp)getApplication()).jsonManager;
        databaseManager = ((MyApp)getApplication()).databaseManager;
        //masterPokeList = ((MyApp)getApplication()).masterPokeList;

        capturedPokemon = getIntent().getExtras().getParcelable("pokemon");
        this.setTitle(capturedPokemon.getPokeName().toUpperCase());

        //databaseManager.getPokeDatabase(this);
        String spriteURL =  databaseGetSpriteURL(capturedPokemon.getPokeName());
        pokemonInfoFetcher = MyApp.pokemonInfoFetcherRecView;

        tvDetailsPokeName.setText(capturedPokemon.getPokeName().toUpperCase());
        //tvDPokeName.setText(capturedPokemon.getPokeName());

        // Table Values
        tvDPokeName.setText( capturedPokemon.getPokeName());
        tvDpokeID.setText(String.valueOf(capturedPokemon.getPokeID()));
        tvDHeight.setText(String.valueOf(capturedPokemon.getHeight()));
        tvDspecies.setText(capturedPokemon.getSpecies());
        Log.d("PokemonActivity", "Poke Deets " + capturedPokemon.getHeight());
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

    @Override
    public void databaseGetListOfPokemon(List<Pokemon> pokemonList) {

    }

    @Override
    public void databaseGetListOfSpecies(List<Species> speciesList) {

    }

    @Override
    public int databaseSearchForPokemonByName(List<Pokemon> pokemonList) {
        return 0;
    }

    @Override
    public String databaseGetSpriteURL(String pokeName) {
        return databaseManager.getSpriteURLInBGThread(pokeName);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.matingButton) {
            //listener.onPokemonSelectedMating(masterPokeList.get(holder.getAdapterPosition()));

            onPokemonSelected(capturedPokemon);
        }

    }

    public void onPokemonSelected(Pokemon selectedPokemon) {
        // Go to pokemon details page
        Intent toMating = new Intent(this, MatingActivity.class);
        toMating.putExtra("pokemon", capturedPokemon);
        //toMating.putExtra("masterSpeciesList", masterSpeciesList);
        startActivity(toMating);
    }

}