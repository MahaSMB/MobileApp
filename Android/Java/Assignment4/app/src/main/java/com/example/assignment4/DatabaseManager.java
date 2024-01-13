package com.example.assignment4;

import android.content.Context;
import androidx.room.Room;

import java.util.List;

public class DatabaseManager {
    interface DatabaseManagerInterfaceListener {
        void databaseGetListOfPokemon(List<Pokemon> pokemonList);
    }

    DatabaseManagerInterfaceListener listener;

    PokeDatabase pokeDatabase;

    PokeDatabase getPokeDatabase(Context context) {
        if (pokeDatabase == null)
            pokeDatabase = Room.databaseBuilder(context, PokeDatabase.class, "database-Pokemon").build();
        return pokeDatabase;
    }

    void getAllPokemonInBGThread() {
        MyApp.executorService.execute(new Runnable() {
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
