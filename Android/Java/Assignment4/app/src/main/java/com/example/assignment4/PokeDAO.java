package com.example.assignment4;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PokeDAO {

    @Query("select * from Pokemon")
    List<Pokemon> getAllPokemon();

}
