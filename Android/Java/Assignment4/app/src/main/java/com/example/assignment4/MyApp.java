package com.example.assignment4;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApp extends Application {

    JSONManager jsonManager = new JSONManager();
    NetworkingManager networkingManager = new NetworkingManager();
    static ExecutorService executorService = Executors.newFixedThreadPool(4);
    static Handler mainhandler = new Handler(Looper.getMainLooper());
    static JSONObject pokemonJSONObject = new JSONObject();
    PokemonInfoFetcher pokemonInfoFetcher = new PokemonInfoFetcher();
    static PokemonInfoFetcher pokemonInfoFetcherRecView = new PokemonInfoFetcher();
    DatabaseManager databaseManager = new DatabaseManager();
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    ArrayList<Species> masterSpeciesList = new ArrayList<>(0);

    ArrayList<EggGroup> masterEggGroupList = new ArrayList<>(0);



}
