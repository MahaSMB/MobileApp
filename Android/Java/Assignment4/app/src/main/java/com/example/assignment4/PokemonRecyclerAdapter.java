package com.example.assignment4;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class PokemonRecyclerAdapter extends
        RecyclerView.Adapter<PokemonRecyclerAdapter.PokemonViewHolder> {
    Context context;
    ArrayList<Pokemon> masterPokeList;
    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    interface PokemonListClickListener {
        void onPokemonSelected(Pokemon selectedPokemon);
    }

    PokemonListClickListener listener;

    public PokemonRecyclerAdapter(Context context, ArrayList<Pokemon> pokeList) {
        this.context = context;
        this.masterPokeList = pokeList;

    }

    @NonNull
    @Override
    public PokemonRecyclerAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.pokemon_list_row, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRecyclerAdapter.PokemonViewHolder holder, int position) {

        TextView tvPokemonID = holder.itemView.findViewById(R.id.tvMPokemonID);
        TextView tvPokemonName = holder.itemView.findViewById(R.id.tvMPokemonName);
        ImageView ivPokemonProfile = holder.itemView.findViewById(R.id.ivMPokemonProfile);
        TextView tvHeight = holder.itemView.findViewById(R.id.tvMHeight);
        TextView tvWeight = holder.itemView.findViewById(R.id.tvMWeight);

        tvPokemonID.setText(String.valueOf(masterPokeList.get(position).getPokeID()));
        tvPokemonName.setText(masterPokeList.get(position).getPokeName());
        String spriteURL =  masterPokeList.get(position).getPokeProfile();

        Glide.with(holder.itemView.getContext()).load(spriteURL).into(ivPokemonProfile);
        tvHeight.setText(String.valueOf(masterPokeList.get(position).getHeight()));
        tvWeight.setText(String.valueOf(masterPokeList.get(position).getWeight()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPokemonSelected(masterPokeList.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return masterPokeList.size();
    }
}
