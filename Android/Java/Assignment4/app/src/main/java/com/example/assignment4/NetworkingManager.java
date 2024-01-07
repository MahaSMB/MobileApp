package com.example.assignment4;


import static android.graphics.ColorSpace.connect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingManager {

    /*
    API: url:"https://pokeapi.co/api/v2/type/1/"

     */

    interface NetworkingInterfaceListener {
        void networkingFinishWithJSONString(String json);
        void networkingFinishWithBitmapImage(Bitmap bitmapPic);
    }
    NetworkingInterfaceListener listener;

    void getPokemon(Pokemon pokeName) {
        String pokemonAPIURL = "https://pokeapi.co/api/v2/pokemon/" + pokeName;
        connect(pokemonAPIURL);
    }

    private void connect(String url) {

        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    URL urlOBJ = new URL(url);
                    httpURLConnection = (HttpURLConnection) urlOBJ.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
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
                    httpURLConnection.disconnect();
                }
            }
        });
    }

    void downloadImage (int pokeID) {
        MyApp.executorService.execute(new Runnable() {

            // front_default:"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
            String pokeProfileURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokeID+".png";
            @Override
            public void run() {
                InputStream inputStream = null;
                try {
                    inputStream = (InputStream) new URL(pokeProfileURL).getContent();
                    Bitmap bitmapPic = BitmapFactory.decodeStream(inputStream);
                    MyApp.mainhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ////////////////////////////////////////////////////////////////////////
                            listener.networkingFinishWithBitmapImage(bitmapPic);
                        }
                    });
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
