package com.example.assignment4;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONManager {

     Pokemon fromJSONObjectToPokemonObj(JSONObject jsonObject) {
        Pokemon pokemonObject = new Pokemon();
        //ArrayList<Pokemon> masterPokeList = new ArrayList<>();

        try {
            //JSONObject jsonObject = new JSONObject(json);
            //JSONArray pokemonSpecies = jsonObject.getJSONArray("species");

            pokemonObject.setPokeID(jsonObject.getInt("id"));
            pokemonObject.setPokeName(jsonObject.getString("name"));
            pokemonObject.setHeight(jsonObject.getInt("height"));
            pokemonObject.setWeight(jsonObject.getInt("weight"));
            JSONObject spriteURLs = new JSONObject( jsonObject.getString("sprites") );
            String spriteFrontDefaultURL2 = spriteURLs.getString("front_default");
            pokemonObject.setPokeProfile(spriteFrontDefaultURL2);
            Log.d("spriteURL-JSONManager", "Sprite: " + spriteFrontDefaultURL2);
            //String spriteFrontDefaultURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"; // + i + ".png";
            //pokemonObject.setPokeProfile(spriteFrontDefaultURL + pokemonObject.getPokeID() + ".png");
            //masterPokeList.add(pokemonObject);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return pokemonObject;
    }

}
