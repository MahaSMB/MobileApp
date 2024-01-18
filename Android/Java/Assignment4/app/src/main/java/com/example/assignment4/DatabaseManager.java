package com.example.assignment4;

import static com.example.assignment4.MyApp.executorService;

import android.content.Context;
import androidx.room.Room;

import java.util.List;

public class DatabaseManager {
    interface DatabaseManagerInterfaceListener {
        void databaseGetListOfPokemon(List<Pokemon> pokemonList);
        int databaseSearchForPokemonByName(List<Pokemon> pokemonList);
    }

    DatabaseManagerInterfaceListener listener;

    PokeDatabase pokeDatabase;

    PokeDatabase getPokeDatabase(Context context) {
        if (pokeDatabase == null) {
            pokeDatabase = Room.databaseBuilder(context,
                    PokeDatabase.class, "database-Pokemon").fallbackToDestructiveMigration().build();
        }
        return pokeDatabase;
    }

    void insertPokemonBackgroundThread(Pokemon pokemon){
        // run the DAO query in background thread.
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                // will run in bg thread
                pokeDatabase.getDao().addNewPokemon(pokemon);
                // no notification is needed.
            }
        });
    }

    int searchForPokemonInBGThread(String pokeName){
        // run the DAO query in background thread.
        final int[] pokeID = {0};
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // will run in bg thread
                List<Pokemon> pokemonList = pokeDatabase.getDao().searchForPokemonByName(pokeName);
                MyApp.mainhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        pokeID[0] =  listener.databaseSearchForPokemonByName(pokemonList);
                    }
                });
            }
        });
        return pokeID[0];
    }

    void getAllPokemonInBGThread() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                List<Pokemon> pokemonList = pokeDatabase.getDao().getAllPokemon();
                MyApp.mainhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //main thread
                        listener.databaseGetListOfPokemon(pokemonList);
                    }
                });
            }
        });
    }
    /*
    * https://developer.android.com/jetpack/androidx/releases/room#kts
    * */
}
