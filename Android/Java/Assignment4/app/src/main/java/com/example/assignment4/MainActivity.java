package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
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

        adapter = new PokemonRecyclerAdapter(this, pokeList);
        adapter.listener = this;
        recyclerView = findViewById(R.id.listviewPokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        int listSize = pokeList.size();
        Log.d("List size", "List Size: " + listSize);

        for (int i = 0; i < 6; i ++) {
            Pokemon newPokemon = new Pokemon(i);
            pokeList.add(newPokemon);
        }

        int listSizeAfter = pokeList.size();
        Log.d("List size", "List Size: " + listSizeAfter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void networkingFinishWithJSONString(String json) {
        pokeList = jsonManager.fromJSONtoArrayListOfPokemon(json);
        adapter.pokeList = pokeList;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void networkingFinishWithBitmapImage(Bitmap bitmapPic) {

    }

    @Override
    public void onPokemonSelected(Pokemon selectedPokemon) {
        // Go to pokemon details page
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