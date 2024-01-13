package com.example.assignment4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONManager {

    Pokemon fromJSONtoPokemonObj (String json) {
        Pokemon pokemonObject = new Pokemon();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray pokemonArray = jsonObject.getJSONArray("pokemon");
            pokemonObject.setPokeID(pokemonArray.getJSONObject(0).getInt("pokeID"));
            pokemonObject.setPokeName(pokemonArray.getJSONObject(0).getString("pokeName"));
            pokemonObject.setPokeProfile(pokemonArray.getJSONObject(0).getString("pokeProfile"));

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return pokemonObject;
    }

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
