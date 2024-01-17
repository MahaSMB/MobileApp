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
        void networkingFinishWithBitMapImage(Bitmap bitmap);
        void networkingFinishWithJSONString(String result);
        Bitmap getBitmapFromSpriteURL(String spriteURL);

        //int searchForPokemonID(String jsonReponse);
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


    public int searchForPokemon(String searchQuery) {
        int id = 0;
        //listener.searchForPokemonID(result);
        return id;
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

            Pokemon newPokemon = new Pokemon(pokeID, pokeName, pokeProfile);
            masterPokeList.add(newPokemon);
            //listener.infoFetchPokemonJSONObj(result);
            //listener.networkingFinishWithJSONString(result);

            MyApp.mainhandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.infoFetchPokemonJSONObj(result);
                    //listener.networkingFinishWithJSONString(result);
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

        // The following goes in Main Activity
//    String pokemonNumber = "1";  // Replace with the desired Pokemon's ID
//    String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonNumber + "/";
//    PokemonInfoFetcher fetcher = new PokemonInfoFetcher();
//    fetcher.execute(url);
    }


    Bitmap downloadImage(String spriteURL){

        MyApp.executorService.execute(new Runnable() {
            //String iconurl = spriteURL;
            @Override
            public void run() {
                InputStream inputStream = null;
                try {
                    inputStream = (InputStream) new URL(spriteURL).getContent();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    MyApp.mainhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.networkingFinishWithBitMapImage(bitmap);
                        }
                    });
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        return listener.getBitmapFromSpriteURL(spriteURL);
    }
}