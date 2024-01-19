package com.example.assignment4;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

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

            // Getting the species object of the pokemon in order to compare egg groups
            JSONObject species = new JSONObject(jsonObject.getString("species"));
            String speciesName = species.getString("name");
            pokemonObject.setSpecies(speciesName);

            // Getting the sprite object of the pokemon to get the string for one of the sprites in the object
            JSONObject spriteURLs = new JSONObject( jsonObject.getString("sprites") );
            String spriteFrontDefaultURL2 = spriteURLs.getString("front_default");
            pokemonObject.setPokeProfile(spriteFrontDefaultURL2);
            Log.d("spriteURL-JSONManager", "Sprite: " + spriteFrontDefaultURL2);
            //String spriteFrontDefaultURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"; // + i + ".png";
            //pokemonObject.setPokeProfile(spriteFrontDefaultURL + pokemonObject.getPokeID() + ".png");
            //masterPokeList.add(pokemonObject);


//            // To get the names of all moves:
//            JSONArray moves = jsonObject.getJSONArray("moves");
//            ArrayList<String> pokeMoves = new ArrayList<>();
//            for (int i = 0; i < moves.length(); i++) {
//                JSONObject move = moves.getJSONObject(i).getJSONObject("move");
//                String moveName = move.getString("name");
//                pokeMoves.add(moveName);
//                //Log.d("JSONManager-Moves", "Move: " + moveName);
//            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return pokemonObject;
    }

    Species fromJSONObjectToSpeciesObj(JSONObject jsonObject) {
        Species speciesObject = new Species();
        String eggGroupName1, eggGroupName2;

        try {
            speciesObject.setSpeciesID(jsonObject.getInt("id"));
            speciesObject.setSpeciesName(jsonObject.getString("name"));

            JSONArray jsonArrayOfEggGroups = new JSONArray(jsonObject.getString("egg_groups"));

            //for (int i = 0; i < jsonArrayOfEggGroups.length() - 1; i++ ) {
                // Getting the egg groups of the species in order to compare pokemon
                eggGroupName1 = jsonArrayOfEggGroups.getJSONObject(0).getString("name");
                eggGroupName2 = jsonArrayOfEggGroups.getJSONObject(1).getString("name");
                Log.d("JSONManager-EggGroup", "EggGroup" + eggGroupName1 + eggGroupName2);
                speciesObject.setEggGroup1(eggGroupName1);
                speciesObject.setEggGroup2(eggGroupName2);
            //}

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
         return speciesObject;
    }

    EggGroup fromJSONObjectToEggGroupObj(JSONObject jsonObject) {
         EggGroup eggGroupObject = new EggGroup();
        ArrayList<String> speciesNameList = new ArrayList<>();
        String speciesInEggGroup = "";
        try {
            eggGroupObject.setEggGroupID(jsonObject.getInt("id"));
            eggGroupObject.setEggGroupName(jsonObject.getString("name"));
            JSONArray jsonArrayOfSpeciesObjects = new JSONArray(jsonObject.getString ("pokemon_species"));

            for (int i = 0; i < jsonArrayOfSpeciesObjects.length() - 1; i++ ) {
                // Getting the ArrayList of species of the egg group in order to compare pokemon
                speciesInEggGroup = jsonArrayOfSpeciesObjects.getJSONObject(i).getString("name");
                Log.d("JSONManager-Species", "Species" + speciesInEggGroup);
                speciesNameList.add(speciesInEggGroup);
            }

            eggGroupObject.setSpecies(speciesNameList);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

         return eggGroupObject;
    }

}
