package com.example.assignment4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EggGroupDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNewEggGroup(EggGroup eggGroup);

    @Query("select * from EggGroup")
    List<EggGroup> getAllEggGroup();

    @Query("select * from EggGroup WHERE egg_groupname LIKE :search")
    List<EggGroup> searchForEggGroupByName(String search);

}
