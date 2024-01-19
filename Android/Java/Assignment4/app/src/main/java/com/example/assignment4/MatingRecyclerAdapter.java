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

public class MatingRecyclerAdapter extends
        RecyclerView.Adapter<MatingRecyclerAdapter.MatingViewHolder> {
    Context context;
    ArrayList<Species> masterSpeciesList;
    ArrayList<EggGroup> masterEggGroupList;
    ArrayList<Pokemon> masterPokeList;

    interface MatingListener {
        //void onPokemonSelectedMating(Pokemon selected);
    }

    MatingListener listener;

    public class MatingViewHolder extends RecyclerView.ViewHolder {
        public MatingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public MatingRecyclerAdapter(Context context, ArrayList<Species> masterSpeciesList) {
        this.context = context;
        this.masterSpeciesList = masterSpeciesList;
    }

    public MatingRecyclerAdapter(Context context, ArrayList<Pokemon> masterPokeList, ArrayList<Species> masterSpeciesList, ArrayList<EggGroup> masterEggGroupList) {
        this.context = context;
        this.masterPokeList = masterPokeList;
        this.masterSpeciesList = masterSpeciesList;
        this.masterEggGroupList = masterEggGroupList;

    }

    @NonNull
    @Override
    public MatingRecyclerAdapter.MatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.mating_list_row, parent, false);
        return new MatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatingRecyclerAdapter.MatingViewHolder holder, int position) {

        TextView tvMPokemonID = holder.itemView.findViewById(R.id.tvMPokemonID);
        TextView tvMPokemonName = holder.itemView.findViewById(R.id.tvMPokemonName);
        ImageView ivMPokemonProfile = holder.itemView.findViewById(R.id.ivMPokemonProfile);
        TextView tvMHeight = holder.itemView.findViewById(R.id.tvMHeight);
        TextView tvMWeight = holder.itemView.findViewById(R.id.tvMWeight);

        tvMPokemonID.setText(String.valueOf(masterSpeciesList.get(position).getSpeciesID()));
        tvMPokemonName.setText(masterSpeciesList.get(position).getSpeciesID());
        String spriteURL =  masterPokeList.get(position).getPokeProfile();

        tvMHeight.setText(String.valueOf(masterSpeciesList.get(position).getEggGroup1()));
        tvMWeight.setText(String.valueOf(masterSpeciesList.get(position).getEggGroup2()));

        Glide.with(holder.itemView.getContext()).load(spriteURL).into(ivMPokemonProfile);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onPokemonSelectedMating(masterPokeList.get(holder.getAdapterPosition()));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return masterSpeciesList.size();
    }
}
