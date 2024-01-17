package com.example.assignment4;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int pokeID;

    @ColumnInfo(name = "pokename")
    String pokeName;

    @ColumnInfo(name = "spriteurl")
    String pokeProfile;

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }
    public void setPokeProfile(String pokeProfile) {
        this.pokeProfile = pokeProfile;
    }

    public Pokemon() {
    }

    public Pokemon(int pokeID, String pokeName, String pokeProfile) {
        this.pokeID = pokeID;
        this.pokeName = pokeName;
        this.pokeProfile = pokeProfile;
    }

    public Pokemon(int pokeID) {
        this.pokeID = pokeID;
    }

      public Pokemon(String pokemonRow) {
      String[] allPokemonInfo =  pokemonRow.split(",");
      this.pokeID = Integer.parseInt(allPokemonInfo[0]);
      this.pokeName = allPokemonInfo[1];
      this.pokeProfile = allPokemonInfo[2];
    }

    protected Pokemon(Parcel in) {
        pokeID = in.readInt();
        pokeName = in.readString();
        pokeProfile = in.readString();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public String getPokeProfile() {

        return pokeProfile;
    }





    // sprite is in png
    // "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",

    public int getPokeID() {

        return pokeID;
    }

    public void setPokeID(int pokeID) {

        this.pokeID = pokeID;
    }

    public String getPokeName() {

        return pokeName;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(pokeID);
        parcel.writeString(pokeName);
        parcel.writeString(pokeProfile);
    }
}
