package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonRecyclerAdapter extends
        RecyclerView.Adapter<PokemonRecyclerAdapter.PokemonViewHolder> {

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    Context context;
    ArrayList<Pokemon> pokeList;

    interface PokemonListClickListener {
        void onPokemonSelected(Pokemon selectedPokemon);
    }

    PokemonListClickListener listener;

    public PokemonRecyclerAdapter(Context context, ArrayList<Pokemon> pokeList) {
        this.context = context;
        this.pokeList = pokeList;
    }

    @NonNull
    @Override
    public PokemonRecyclerAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.pokemon_list_row, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRecyclerAdapter.PokemonViewHolder holder, int position) {

        TextView tvPokemonID = holder.itemView.findViewById(R.id.tvPokemonID);
        TextView tvPokemonName = holder.itemView.findViewById(R.id.tvPokemonName);
        ImageView ivPokemonProfile = holder.itemView.findViewById(R.id.ivPokemonProfile);

        tvPokemonID.setText(pokeList.get(position).getPokeID());
        tvPokemonName.setText(pokeList.get(position).getPokeName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPokemonSelected(pokeList.get(holder.getAdapterPosition()));
            }
        });
        /*
        * Work on this some more
        * */
    }

    @Override
    public int getItemCount() {
        return pokeList.size();
    }
}
