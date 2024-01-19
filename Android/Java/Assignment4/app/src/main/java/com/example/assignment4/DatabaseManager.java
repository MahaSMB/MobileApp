package com.example.assignment4;

import static com.example.assignment4.MyApp.executorService;

import android.content.Context;
import androidx.room.Room;

import java.util.List;

public class DatabaseManager {
    interface DatabaseManagerInterfaceListener {
        void databaseGetListOfPokemon(List<Pokemon> pokemonList);
        void databaseGetListOfSpecies(List<Species> speciesList);
        int databaseSearchForPokemonByName(List<Pokemon> pokemonList);
        String databaseGetSpriteURL(String pokeName);
    }

    DatabaseManagerInterfaceListener listener;

    PokeDatabase pokeDatabase;

    SpeciesDatabase speciesDatabase;

    EggGroupDatabase eggGroupDatabase;

    PokeDatabase getPokeDatabase(Context context) {
        if (pokeDatabase == null) {
            pokeDatabase = Room.databaseBuilder(context,
                    PokeDatabase.class, "database-Pokemon").fallbackToDestructiveMigration().build();
        }
        return pokeDatabase;
    }

    SpeciesDatabase getSpeciesDatabase(Context context) {
        if (speciesDatabase == null) {
            speciesDatabase = Room.databaseBuilder(context,
                    SpeciesDatabase.class, "database-Species").fallbackToDestructiveMigration().build();
        }
        return speciesDatabase;
    }

    EggGroupDatabase getEggGroupDatabase(Context context) {
        if (eggGroupDatabase == null) {
            eggGroupDatabase = Room.databaseBuilder(context,
                    EggGroupDatabase.class, "database-EggGroup").fallbackToDestructiveMigration().build();
        }
        return eggGroupDatabase;
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

    void insertSpeciesInBackgroundThread(Species species){
        // run the DAO query in background thread.
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                // will run in bg thread
                speciesDatabase.getDao().addNewSpecies(species);
                // no notification is needed.
            }
        });
    }

    void insertEggGroupInBackgroundThread(EggGroup eggGroup){
        // run the DAO query in background thread.
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                // will run in bg thread
                eggGroupDatabase.getDao().addNewEggGroup(eggGroup);
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

    String getSpriteURLInBGThread(String pokeName) {
        final String[] spriteURL = {""};
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                spriteURL[0] = pokeDatabase.getDao().getSpriteURL(pokeName);
                MyApp.mainhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //main thread
                        spriteURL[0] = listener.databaseGetSpriteURL(pokeName);
                    }
                });
            }
        });
        return spriteURL[0];
    }

    void getAllSpeciesInBGThread() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                List<Species> speciesList = speciesDatabase.getDao().getAllSpecies();
                MyApp.mainhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //main thread
                        listener.databaseGetListOfSpecies(speciesList);
                    }
                });
            }
        });
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
