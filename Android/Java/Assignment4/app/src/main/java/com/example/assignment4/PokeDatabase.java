package com.example.assignment4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class}, version = 2, exportSchema = false)
public abstract class PokeDatabase extends RoomDatabase {
    public abstract PokeDAO getDao();

    public void setAdapter(PokemonRecyclerAdapter adapter) {
    }
}
