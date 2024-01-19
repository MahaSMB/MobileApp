package com.example.assignment4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Species.class}, version = 1, exportSchema = false)
public abstract class SpeciesDatabase extends RoomDatabase {
    public abstract SpeciesDAO getDao();

    public void setAdapter(MatingRecyclerAdapter adapter) {
    }
}