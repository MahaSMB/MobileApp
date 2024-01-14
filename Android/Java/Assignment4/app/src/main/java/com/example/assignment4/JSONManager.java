package com.example.assignment4;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONManager {

    ArrayList<Pokemon> fromJSONtoPokemonObj (String json) {
        Pokemon pokemonObject = new Pokemon();
        ArrayList<Pokemon> masterPokeList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(json);
//            JSONArray pokemonSpecies = jsonObject.getJSONArray("pokemon_species");
//            pokemonObject.setPokeID(pokemonSpecies.getJSONObject(0).getInt("pokeID"));
//            pokemonObject.setPokeName(pokemonSpecies.getJSONObject(0).getString("name"));
//            pokemonObject.setPokeProfile(pokemonSpecies.getJSONObject(0).getString("pokeProfile"));

            JSONArray pokemonSpecies = jsonObject.getJSONArray("species");
            //for (int i = 1; i < pokemonSpecies.length(); i++) {
            //for (int i = 1; i < 3; i++) {
                pokemonObject.setPokeID(jsonObject.getInt("id"));
                pokemonObject.setPokeName(jsonObject.getString("name"));
                JSONObject spriteURLs = new JSONObject( jsonObject.getString("sprites") );
                String spriteFrontDefaultURL2 = spriteURLs.getString("front_default");
                Log.d("spriteURL", "Sprite" + spriteFrontDefaultURL2);
                String spriteFrontDefaultURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"; // + i + ".png";
                pokemonObject.setPokeProfile(spriteFrontDefaultURL + pokemonObject.getPokeID() + ".png");
                masterPokeList.add(pokemonObject);
            //}

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return masterPokeList;
    }

    // Not sure I need the function below
    ArrayList<Pokemon> fromJSONtoArrayListOfPokemon(String json) {
        ArrayList<Pokemon> list = new ArrayList<>(0);

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(new Pokemon(Integer.parseInt(jsonArray.get(i).toString())));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

}
