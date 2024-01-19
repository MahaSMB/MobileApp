package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatingActivity extends AppCompatActivity implements
        DatabaseManager.DatabaseManagerInterfaceListener,
        PokemonInfoFetcher.infoFetchListener, MatingRecyclerAdapter.MatingListener {

    PokemonInfoFetcher pokemonInfoFetcher;
    DatabaseManager databaseManager;

    SpeciesDatabase speciesDatabase;
    EggGroupDatabase eggGroupDatabase;
    Species newSpeciesFromJSON;
    EggGroup newEggGroupFromJSON;
    JSONManager jsonManager;
    MatingRecyclerAdapter adapter;
    RecyclerView matingRecyclerView;

    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    ArrayList<Species> masterSpeciesList = new ArrayList<>(0);

    ArrayList<EggGroup> masterEggGroupList = new ArrayList<>(0);

    Pokemon capturedPokemon;

    ImageView ivMDetailsPokeProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mating);
        ivMDetailsPokeProfile = findViewById(R.id.ivMDetailsPokeProfile);

        capturedPokemon = (getIntent().getExtras()).getParcelable("pokemon");

        if (savedInstanceState != null) {
            //masterSpeciesList = savedInstanceState.getParcelableArrayList("masterSpeciesList");
            //masterEggGroupList = savedInstanceState.getParcelableArrayList("masterEggGroupList");
            capturedPokemon = Objects.requireNonNull(getIntent().getExtras()).getParcelable("pokemon");
        }
        jsonManager = ((MyApp) getApplication()).jsonManager;
        databaseManager = ((MyApp) getApplication()).databaseManager;

        masterPokeList = ((MyApp) getApplication()).masterPokeList;
        masterSpeciesList = ((MyApp) getApplication()).masterSpeciesList;
        masterEggGroupList = ((MyApp) getApplication()).masterEggGroupList;

        pokemonInfoFetcher = ((MyApp) getApplication()).pokemonInfoFetcher;

        pokemonInfoFetcher.listener = this; // Setting the context for PokemonInfoFetcher
        MyApp.pokemonInfoFetcherRecView.listener = this;

        this.setTitle(capturedPokemon.getPokeName().toUpperCase());

        String spriteURL =  databaseGetSpriteURL(capturedPokemon.getPokeName());
        pokemonInfoFetcher = MyApp.pokemonInfoFetcherRecView;

        // To Display the Pokemon Sprite
        Glide.with(this)
                .load(spriteURL)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.pokeball_background) //placeholder image
                        .error(R.drawable.error_image_foreground)  //error image in case of a loading error
                )
                .into(ivMDetailsPokeProfile);

        // Rate Limit issue
        // Fetch Pokemon data
        // "https://pokeapi.co/api/v2/pokemon?limit=152"

        // Fetch Species data
        // "https://pokeapi.co/api/v2/pokemon-species?limit=152/"

        // Fetch Egg Group data
        // "https://pokeapi.co/api/v2/egg-group?limit=16"


        String pokeURL = "https://pokeapi.co/api/v2/pokemon?limit=152";
        String speciesURL = "https://pokeapi.co/api/v2/pokemon-species?limit=152";
        String eggGroupURL = "https://pokeapi.co/api/v2/egg-group?limit=16";
        PokemonInfoFetcher fetcher = new PokemonInfoFetcher();
        fetcher.listener = this;
        //Log.d("PokemonCapture", "" + pokemonNumber);
        //fetcher.execute(pokeURL); // Fetches pokemon data
        fetcher.execute(speciesURL); // Fetches species data
        //fetcher.execute(eggGroupURL); // Fetches egg group data

        databaseManager.getSpeciesDatabase(this);
        databaseManager.listener = this;

        adapter = new MatingRecyclerAdapter(this, masterPokeList, masterSpeciesList, masterEggGroupList);
        adapter.listener = this;
        matingRecyclerView = findViewById(R.id.matingRecyclerView);
        matingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        matingRecyclerView.setAdapter(adapter);

    }

    @Override
    public void databaseGetListOfPokemon(List<Pokemon> pokemonList) {

    }

    @Override
    public void databaseGetListOfSpecies(List<Species> speciesList) {
        adapter = new MatingRecyclerAdapter(this, (ArrayList<Species>) masterSpeciesList);
        speciesDatabase.setAdapter(adapter); // this method is abstract, needs an implementation
        adapter.listener = this;
    }

    @Override
    public int databaseSearchForPokemonByName(List<Pokemon> pokemonList) {
        return 0;
    }

    @Override
    public String databaseGetSpriteURL(String pokeName) {
        return null;
    }

    @Override
    public void infoFetchPokemonJSONObj(String result) {
        try {
            //JSONObject pokemonJSONObj = new JSONObject(result);
            JSONObject speciesJSONObj = new JSONObject(result);
            JSONObject eggGroupJSONObj = new JSONObject(result);
            //newPokemonFromJSON = jsonManager.fromJSONObjectToPokemonObj(pokemonJSONObj);
            newSpeciesFromJSON = jsonManager.fromJSONObjectToSpeciesObj(speciesJSONObj);
            newEggGroupFromJSON = jsonManager.fromJSONObjectToEggGroupObj(eggGroupJSONObj);
            //databaseManager.insertPokemonBackgroundThread(newPokemonFromJSON);
            databaseManager.insertSpeciesInBackgroundThread(newSpeciesFromJSON);
            databaseManager.insertEggGroupInBackgroundThread(newEggGroupFromJSON);
            //((MyApp) getApplication()).masterPokeList.add(newPokemonFromJSON);
            ((MyApp) getApplication()).masterSpeciesList.add(newSpeciesFromJSON);
            ((MyApp) getApplication()).masterEggGroupList.add(newEggGroupFromJSON);
            adapter.masterSpeciesList = ((MyApp) getApplication()).masterSpeciesList;
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.d("MainActivity", "Error parsing JSON", e);
            e.printStackTrace();
        }
    }
}