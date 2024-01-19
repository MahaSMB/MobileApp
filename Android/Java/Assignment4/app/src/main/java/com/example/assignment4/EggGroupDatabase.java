package com.example.assignment4;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter;

@Database(entities = {EggGroup.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class EggGroupDatabase extends RoomDatabase {
    public abstract EggGroupDAO getDao();

}
