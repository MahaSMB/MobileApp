package com.example.assignment4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SpeciesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNewSpecies(Species Species);

    @Query("select * from Species")
    List<Species> getAllSpecies();

    @Query("select * from Species WHERE speciesname LIKE :search")
    List<Species> searchForSpeciesByName(String search);

//    @Query("select spriteurl from Species WHERE speciesname LIKE :search")
//    String getSpriteURL(String search);

}
