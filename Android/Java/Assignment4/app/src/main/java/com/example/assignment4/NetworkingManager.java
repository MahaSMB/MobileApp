package com.example.assignment4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetworkingManager {

    ArrayList<Pokemon> masterPokeList = new ArrayList<>();

    /*
    API: url:"https://pokeapi.co/api/v2/type/1/"

     */

    interface NetworkingInterfaceListener {
        void networkingFinishWithJSONString(String json);
        void networkingFinishWithBitmapImage(Bitmap bitmapPic);
    }
    NetworkingInterfaceListener listener;

    void getPokemon() {
        // make sure the URL is a query a la
        // String urlString = "http://gd.geobytes.com/AutoCompleteCity?&q=" + query;
        // https://pokeapi.co/api/v2/pokemon/{id or name}/

        int numberOfPokemonToRetrieve = 5;

        for (int i = 1; i < numberOfPokemonToRetrieve; i++) {

            // use the get command with this API
            String pokemonAPIURL = "https://pokeapi.co/api/v2/pokemon/" + i ;

            //int currentPokemonID = i;
            //String currentPokemonName = pokemonAPIURL;
            //String currentPokemonProfile = ;

            //Pokemon newPokemon = new Pokemon(i, currentPokemonName, currentPokemonProfile);

            //Pokemon newPokemon = new Pokemon(i);
            //String pokeTestName = newPokemon.getPokeName();
            //Log.d("Test", "Test" + pokeTestName);
            //masterPokeList.add(newPokemon);

            connect(pokemonAPIURL);

            //Pokemon newPokemon = new Pokemon(1);
            /*
            Make sure this is running in a background thread
             */
        }

    }

    private void connect(String url) {
        HttpURLConnection httpURLConnection = null;
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    // this code will work with any http function (get, post, put , delete)
                    URL urlOBJ = new URL(url);
                    httpURLConnection = (HttpURLConnection) urlOBJ.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    StringBuilder buffer = new StringBuilder();
                    int var;

                    while ((var = inputStream.read()) != -1) {
                        buffer.append((char) var);
                    }
                    String jsonResponse = buffer.toString();
                    MyApp.mainhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // runs in main thread
                            /////////////////////////////////////////////////////////////////////
                            listener.networkingFinishWithJSONString(jsonResponse);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("There is an error.");
                    e.printStackTrace();
                }
                finally {
                    assert httpURLConnection != null;
                    httpURLConnection.disconnect();
                }
            }
        });
    }

//    void downloadImage (int pokeID) {
//        MyApp.executorService.execute(new Runnable() {
//
//            // front_default:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
//            String pokeProfileURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokeID+".png";
//            @Override
//            public void run() {
//                InputStream inputStream = null;
//                try {
//                    inputStream = (InputStream) new URL(pokeProfileURL).getContent();
//                    Bitmap bitmapPic = BitmapFactory.decodeStream(inputStream);
//                    MyApp.mainhandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            ////////////////////////////////////////////////////////////////////////
//                            listener.networkingFinishWithBitmapImage(bitmapPic);
//                        }
//                    });
//                    inputStream.close();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
