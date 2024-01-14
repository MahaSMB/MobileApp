package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NetworkingManager.NetworkingInterfaceListener,
        PokemonRecyclerAdapter.PokemonListClickListener,
        DatabaseManager.DatabaseManagerInterfaceListener {

    NetworkingManager networkingManager;
    JSONManager jsonManager;
    PokemonRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Pokemon> pokeList = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            pokeList = savedInstanceState.getParcelableArrayList("pokeList");
        }
        networkingManager = ((MyApp)getApplication()).networkingManager;
        jsonManager = ((MyApp)getApplication()).jsonManager;
        networkingManager.listener = this;
//        for (int i = 0; i < 6; i++) {
//            String pokeURL =  "https://pokeapi.co/api/v2/pokemon/${i}/";
//            Log.d("test", "testing " + pokeURL);
//        }
        adapter = new PokemonRecyclerAdapter(this, pokeList);
        adapter.listener = this;
        recyclerView = findViewById(R.id.recviewPokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

//        int listSize = pokeList.size();
//        Log.d("List size", "List Size: " + listSize);
//
//        for (int i = 0; i < 6; i ++) {
//            Pokemon newPokemon = new Pokemon(i);
//            pokeList.add(newPokemon);
//        }
//
//        int listSizeAfter = pokeList.size();
//        Log.d("List size", "List Size: " + listSizeAfter);
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
                    networkingManager.getPokemon(s);
                }
                else {
                    adapter.pokeList = new ArrayList<>(0);
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
    public void networkingFinishWithJSONString(String json) {
        pokeList = jsonManager.fromJSONtoPokemonObj(json); // returns pokemon list read from pokeapi
        adapter.pokeList = pokeList;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void networkingFinishWithBitmapImage(Bitmap bitmapPic) {

    }

    @Override
    public void onPokemonSelected(Pokemon selectedPokemon) {
        // Go to pokemon details page
        Intent toPokemon = new Intent(this, PokemonActivity.class);
        toPokemon.putExtra("city",selectedPokemon);
        startActivity(toPokemon);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelableArrayList("pokeList", pokeList);
    }

    @Override
    public void databaseGetListOfPokemon(List<Pokemon> pokemonList) {
        //adapter = new PokemonRecyclerAdapter(this, (ArrayList<Pokemon>) pokemonList);
        adapter = new PokemonRecyclerAdapter(this, pokeList);
        recyclerView.setAdapter(adapter);
        adapter.listener = this;
    }
}