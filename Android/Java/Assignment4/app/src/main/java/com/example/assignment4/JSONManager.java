package com.example.assignment4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

}
