package com.example.assignment4;

import static com.example.assignment4.MyApp.pokemonJSONObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        PokemonRecyclerAdapter.PokemonListClickListener,
        DatabaseManager.DatabaseManagerInterfaceListener,
        PokemonInfoFetcher.infoFetchListener {

    String searchQuery;
    PokemonInfoFetcher pokemonInfoFetcher;
    DatabaseManager databaseManager;
    PokeDatabase pokeDatabase;
    ContactsContract.Directory directory;

    SpeciesDatabase speciesDatabase;

    EggGroupDatabase eggGroupDatabase;

    Pokemon newPokemonFromJSON;

//    Species newSpeciesFromJSON;
//    EggGroup newEggGroupFromJSON;
    JSONManager jsonManager;
    PokemonRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            masterPokeList = savedInstanceState.getParcelableArrayList("masterPokeList");
        }
        jsonManager = ((MyApp) getApplication()).jsonManager;
        databaseManager = ((MyApp) getApplication()).databaseManager;

        masterPokeList = ((MyApp) getApplication()).masterPokeList;
        pokemonInfoFetcher = ((MyApp) getApplication()).pokemonInfoFetcher;

        pokemonInfoFetcher.listener = this; // Setting the context for PokemonInfoFetcher
        MyApp.pokemonInfoFetcherRecView.listener = this;
        for (int i = 1; i < 152; i++) {
            //String pokemonNumber = "92";  // Replace with the desired Pokemon's ID
            String pokemonNumber = String.valueOf(i);

            // Rate Limit issue
            // Fetch Pokemon data
            // "https://pokeapi.co/api/v2/pokemon?limit=152"

            // Fetch Species data
            // "https://pokeapi.co/api/v2/pokemon-species?limit=152/"

            // Fetch Egg Group data
            // "https://pokeapi.co/api/v2/egg-group?limit=16"


            String pokeURL = "https://pokeapi.co/api/v2/pokemon/" + pokemonNumber;
            String speciesURL = "https://pokeapi.co/api/v2/pokemon-species?limit=152";
            String eggGroupURL = "https://pokeapi.co/api/v2/egg-group?limit=16";
            PokemonInfoFetcher fetcher = new PokemonInfoFetcher();
            fetcher.listener = this;
            //Log.d("PokemonCapture", "" + pokemonNumber);
            fetcher.execute(pokeURL); // Fetches pokemon data
            //fetcher.execute(speciesURL); // Fetches species data
            //fetcher.execute(eggGroupURL); // Fetches egg group data
            //Pokemon newPokemon = new Pokemon(i);
            //masterPokeList.add(newPokemon);

//            if (!directory() == null) {
//                if (parentDir.mkdirs()) {
//                    Log.d("TAG", "Successfully created the parent dir:" + parentDir.getName());
//                } else {
//                    Log.d("TAG", "Failed to create the parent dir:" + parentDir.getName());
//                }
//            }

        }
        databaseManager.getPokeDatabase(this);
        databaseManager.listener = this;

        adapter = new PokemonRecyclerAdapter(this, masterPokeList);
        adapter.listener = this;
        recyclerView = findViewById(R.id.recviewPokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.searchpokemon, menu);
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        SearchView menuSearchItem = (SearchView) menu.findItem(R.id.searchbar_menu_item).getActionView();
        menuSearchItem.setQueryHint("Search for Pokemon");
        menuSearchItem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onQueryTextChange(String searchQuery) {
                if (searchQuery.length() > 2) {
                    //networkingManager.getPokemon();
                    //int pokemonNumber = databaseSearchForPokemonByName( (List<Pokemon>) masterPokeList);

                    Intent foundPokemon = new Intent(MainActivity.this, PokemonActivity.class);
                    foundPokemon.putExtra("pokemon", searchQuery);
                    startActivity(foundPokemon);
                } else {
                    adapter.masterPokeList = ((MyApp) getApplication()).masterPokeList;
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(this, PokemonActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
        //databaseManager.getAllPokemonInBGThread();
        ////restartActivity(MainActivity.this);
    }


    @Override
    public void onPokemonSelected(Pokemon selectedPokemon) {
        // Go to pokemon details page
        Intent toPokemon = new Intent(this, PokemonActivity.class);
        toPokemon.putExtra("pokemon", selectedPokemon);
        startActivity(toPokemon);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelableArrayList("pokeList", masterPokeList);
    }

    @Override
    public void databaseGetListOfPokemon(List<Pokemon> pokemonList) {

        adapter = new PokemonRecyclerAdapter(this, (ArrayList<Pokemon>) masterPokeList);
        pokeDatabase.setAdapter(adapter); // this method is abstract, needs an implementation
        adapter.listener = this;

    }

    @Override
    public void databaseGetListOfSpecies(List<Species> speciesList) {

    }

    @Override
    public int databaseSearchForPokemonByName(List<Pokemon> pokemonList) {
        return databaseManager.searchForPokemonInBGThread(searchQuery);
    }

    @Override
    public String databaseGetSpriteURL(String pokeName) {
        return databaseManager.getSpriteURLInBGThread(pokeName);
    }

    public void infoFetchPokemonJSONObj(String result) {
        try {
            JSONObject pokemonJSONObj = new JSONObject(result);
            //JSONObject speciesJSONObj = new JSONObject(result);
            //JSONObject eggGroupJSONObj = new JSONObject(result);
            newPokemonFromJSON = jsonManager.fromJSONObjectToPokemonObj(pokemonJSONObj);
            //newSpeciesFromJSON = jsonManager.fromJSONObjectToSpeciesObj(speciesJSONObj);
            //newEggGroupFromJSON = jsonManager.fromJSONObjectToEggGroupObj(eggGroupJSONObj);
            databaseManager.insertPokemonBackgroundThread(newPokemonFromJSON);
            //databaseManager.insertSpeciesInBackgroundThread(newSpeciesFromJSON);
            //databaseManager.insertEggGroupInBackgroundThread(newEggGroupFromJSON);
            ((MyApp) getApplication()).masterPokeList.add(newPokemonFromJSON);
            //((MyApp) getApplication()).masterSpeciesList.add(newSpeciesFromJSON);
            //((MyApp) getApplication()).masterEggGroupList.add(newEggGroupFromJSON);
            adapter.masterPokeList = ((MyApp) getApplication()).masterPokeList;
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.d("MainActivity", "Error parsing JSON", e);
            e.printStackTrace();
        }
    }

    public void restartActivity(Activity activity) {
        Intent i = activity.getIntent();
        activity.finish();

        // Clearing RecyclerView so new rows are not created when the activity restarts
        activity.startActivity(i);
        /*
        https://stackoverflow.com/questions/1397361/how-to-restart-activity-in-android
        */
    }
}