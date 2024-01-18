package com.example.assignment4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PokemonInfoFetcher extends AsyncTask<String, Void, String> {

    interface infoFetchListener {
        void infoFetchPokemonJSONObj(String result);

    }

    infoFetchListener listener;

    @Override
    public String doInBackground(String... strings) {
        String result = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            Log.e("PokemonInfoFetcher", "Error making HTTP request", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }

    public void onPostExecute(String result) {

        ArrayList<Pokemon> masterPokeList = new ArrayList<>();

        try {
            JSONObject pokemonJSONObj = new JSONObject(result);
            // Process the JSON data as needed
            // For example, to get the height and weight:
            String pokeName = pokemonJSONObj.getString("name");
            int pokeID = pokemonJSONObj.getInt("id");

            JSONObject spriteURLs = new JSONObject(pokemonJSONObj.getString("sprites"));
            String spriteFrontDefaultURL = spriteURLs.getString("front_default");
            String pokeProfile = spriteFrontDefaultURL + pokeID + ".png";

            //Pokemon newPokemon = new Pokemon(pokeID, pokeName, pokeProfile);
            //masterPokeList.add(newPokemon);

            MyApp.mainhandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.infoFetchPokemonJSONObj(result);
                }
            });

            int height = pokemonJSONObj.getInt("height");
            int weight = pokemonJSONObj.getInt("weight");
            Log.d("PokemonInfo", "Name:" + pokeName + ", ID: " + pokeID +
                    ", Height: " + height + ", Weight: " + weight);

            // To get the names of all moves:
            JSONArray moves = pokemonJSONObj.getJSONArray("moves");

//            for (int i = 0; i < moves.length(); i++) {
//                JSONObject move = moves.getJSONObject(i).getJSONObject("move");
//                String moveName = move.getString("name");
//                Log.d("PokemonInfo", "Move: " + moveName);
//            }

        } catch (JSONException e) {
            Log.e("PokemonInfoFetcher", "Error parsing JSON", e);
        }

    }

}