package com.example.assignment4;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int pokeID;
    String pokeName;
    String pokeProfile;

    public Pokemon() {
    }

    public Pokemon(int pokeID, String pokeName, String pokeProfile) {
        this.pokeID = pokeID;
        this.pokeName = pokeName;
        this.pokeProfile = pokeProfile;
    }

    /*

        public City(String cityRow){
      String[] allCityNames =  cityRow.split(",");
      this.city = allCityNames[0];
      this.state = allCityNames[1];
      this.country = allCityNames[2];
    }
    See if I need to implement this

     */

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

    public void setPokeProfile(String pokeProfile) {

        this.pokeProfile = pokeProfile;
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

    public void setPokeName(String pokeName) {

        this.pokeName = pokeName;
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
