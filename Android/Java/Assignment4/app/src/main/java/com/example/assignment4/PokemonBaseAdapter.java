package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PokemonBaseAdapter extends BaseAdapter {

    ArrayList<Pokemon> arrayListOfPokemon;
    Context activityContext;

    public PokemonBaseAdapter(ArrayList<Pokemon> arrayListOfPokemon, Context activityContext) {
        this.arrayListOfPokemon = arrayListOfPokemon;
        this.activityContext = activityContext;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View pokemonRowView =  LayoutInflater.from(activityContext).inflate(R.layout.pokemon_list_row,
                parent, false);

        TextView tvPokemonID = pokemonRowView.findViewById(R.id.tvPokemonID);
        TextView tvPokemonName = pokemonRowView.findViewById(R.id.tvPokemonName);
        ImageView ivPokemonProfile = pokemonRowView.findViewById(R.id.ivPokemonProfile);

        tvPokemonID.setText(arrayListOfPokemon.get(position).getPokeID());
        tvPokemonName.setText(arrayListOfPokemon.get(position).getPokeName());

        return pokemonRowView;
    }
}
