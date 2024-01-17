package com.example.assignment4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.loader.ResourcesLoader;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonRecyclerAdapter extends
        RecyclerView.Adapter<PokemonRecyclerAdapter.PokemonViewHolder> {
    Context context;
    PokemonInfoFetcher pokemonInfoFetcher;
    ArrayList<Pokemon> masterPokeList;
//
//    @Override
//    public void infoFetchPokemonJSONObj(String result) {
//
//    }
//
//    @Override
//    public void networkingFinishWithBitMapImage(Bitmap bitmap) {
//
//    }
//
//    @Override
//    public void networkingFinishWithJSONString(String result) {
//
//    }
//
//    @Override
//    public Bitmap getBitmapFromSpriteURL(String spriteURL) {
//        return null;
//    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    //Context context;


    interface PokemonListClickListener {
        void onPokemonSelected(Pokemon selectedPokemon);
        Bitmap getBitmap(String spriteURL);
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

        TextView tvPokemonID = holder.itemView.findViewById(R.id.tvPokemonID);
        TextView tvPokemonName = holder.itemView.findViewById(R.id.tvPokemonName);
        ImageView ivPokemonProfile = holder.itemView.findViewById(R.id.ivPokemonProfile);

        tvPokemonID.setText(String.valueOf(masterPokeList.get(position).getPokeID()));
        tvPokemonName.setText(masterPokeList.get(position).getPokeName());
        String spriteURL =  masterPokeList.get(position).getPokeProfile();
        pokemonInfoFetcher = MyApp.pokemonInfoFetcherRecView;
        Log.d("spriteURL-PokemonRecycler", "Sprite: " + spriteURL);
        Bitmap bitmap =  pokemonInfoFetcher.downloadImage(spriteURL);
        Drawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmap);
        //ivPokemonProfile.setImageDrawable( bitmapDrawable );
        ivPokemonProfile.setImageBitmap(bitmap);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPokemonSelected(masterPokeList.get(holder.getAdapterPosition()));
            }
        });
        /*
        * Work on this some more
        * */
    }

    @Override
    public int getItemCount() {
        return masterPokeList.size();
    }
}
