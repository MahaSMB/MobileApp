package com.example.assignment4;

import static com.example.assignment4.MyApp.pokemonJSONObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        PokemonRecyclerAdapter.PokemonListClickListener,
        DatabaseManager.DatabaseManagerInterfaceListener,
        PokemonInfoFetcher.infoFetchListener {

    PokemonInfoFetcher pokemonInfoFetcher;
    Pokemon newPokemonFromJSON;
    JSONManager jsonManager;
    PokemonRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);
    ArrayList<Pokemon> pokeList = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            masterPokeList = savedInstanceState.getParcelableArrayList("masterPokeList");
        }
        jsonManager = ((MyApp)getApplication()).jsonManager;

        masterPokeList = ((MyApp)getApplication()).masterPokeList;
        pokemonInfoFetcher = ((MyApp)getApplication()).pokemonInfoFetcher;

        pokemonInfoFetcher.listener = this; // Setting the context for PokemonInfoFetcher
        MyApp.pokemonInfoFetcherRecView.listener = this;
        for (int i = 1; i < 10; i++) {
            //String pokemonNumber = "92";  // Replace with the desired Pokemon's ID
            String pokemonNumber = String.valueOf(i);
            String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonNumber + "/";
            PokemonInfoFetcher fetcher = new PokemonInfoFetcher();
            fetcher.listener = this;
            Log.d("PokemonCapture", "" + pokemonNumber);
            fetcher.execute(url);
            //Pokemon newPokemon = new Pokemon(i);
            //masterPokeList.add(newPokemon);
        }

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
            public boolean onQueryTextChange(String s) {
                if (s.length() > 2){
                    //networkingManager.getPokemon();
                    // ******************** INCOMPLETE ************************************ /
                    pokemonInfoFetcher.onPostExecute(s);
                }
                else {
                    adapter.masterPokeList = ((MyApp)getApplication()).masterPokeList;
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
    }

    @Override
    public void networkingFinishWithJSONString(String spriteURL) {
        pokemonInfoFetcher.downloadImage(spriteURL);
        Log.d("spriteURL-Main", "Sprite: " + spriteURL);
    }

    @Override
    public Bitmap getBitmapFromSpriteURL(String spriteURL) {
        return null;
    }


    @Override
    public void onPokemonSelected(Pokemon selectedPokemon) {
        // Go to pokemon details page
        Intent toPokemon = new Intent(this, PokemonActivity.class);
        toPokemon.putExtra("pokemon",selectedPokemon);
        startActivity(toPokemon);
    }

    @Override
    public Bitmap getBitmap(String spriteURL) {
        return null;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelableArrayList("pokeList", pokeList);
    }

    @Override
    public void databaseGetListOfPokemon(List<Pokemon> pokemonList) {
        //adapter = new PokemonRecyclerAdapter(this, (ArrayList<Pokemon>) pokemonList);
        adapter = new PokemonRecyclerAdapter(this, masterPokeList);
        recyclerView.setAdapter(adapter);
        adapter.listener = this;
        //adapter.notifyDataSetChanged();
    }

    public void infoFetchPokemonJSONObj(String result){
        try {
            JSONObject pokemonJSONObj = new JSONObject(result);
            newPokemonFromJSON = jsonManager.fromJSONObjectToPokemonObj(pokemonJSONObj);
            ((MyApp) getApplication()).masterPokeList.add(newPokemonFromJSON);
            adapter.masterPokeList = ((MyApp) getApplication()).masterPokeList;
            adapter.notifyDataSetChanged();
        }
        catch (JSONException e) {
            Log.d("MainActivity", "Error parsing JSON", e);
            e.printStackTrace();
        }
    }

    @Override
    public void networkingFinishWithBitMapImage(Bitmap bitmap) {

    }

}