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

    @ColumnInfo(name = "height")
    int height;

    @ColumnInfo(name = "weight")
    int weight;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @ColumnInfo(name = "species")
    String species;

    @ColumnInfo(name = "spriteurl")
    String pokeProfile;


    protected Pokemon(Parcel in) {
        pokeID = in.readInt();
        pokeName = in.readString();
        height = in.readInt();
        weight = in.readInt();
        species = in.readString();
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





    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }
    public void setPokeProfile(String pokeProfile) {
        this.pokeProfile = pokeProfile;
    }

    public Pokemon() {
    }

    public Pokemon(int pokeID, String pokeName, int height, int weight, String species, String pokeProfile) {
        this.pokeID = pokeID;
        this.pokeName = pokeName;
        this.height = height;
        this.weight = weight;
        this.species = species;
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
      this.height = Integer.parseInt(allPokemonInfo[3]);
      this.weight = Integer.parseInt(allPokemonInfo[4]);
      this.species = allPokemonInfo[5];
    }

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
        parcel.writeInt(height);
        parcel.writeInt(weight);
        parcel.writeString(pokeProfile);
        parcel.writeString(species);
    }

}
