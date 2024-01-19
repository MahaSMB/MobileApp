package com.example.assignment4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PokeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNewPokemon(Pokemon pokemon);

    @Query("select * from Pokemon")
    List<Pokemon> getAllPokemon();

    @Query("select * from Pokemon WHERE pokename LIKE :search")
    List<Pokemon> searchForPokemonByName(String search);

    @Query("select spriteurl from Pokemon WHERE pokename LIKE :search")
    String getSpriteURL(String search);

}
