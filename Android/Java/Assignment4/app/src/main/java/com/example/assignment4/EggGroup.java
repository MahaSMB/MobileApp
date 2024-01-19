package com.example.assignment4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


@Entity
public class EggGroup implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int eggGroupID;


    @ColumnInfo (name ="egg_groupname")
    String eggGroupName;

    @ColumnInfo (name ="egg_species")
    ArrayList<String> species;

    public EggGroup() {
    }

    public EggGroup(int eggGroupID) {
        this.eggGroupID = eggGroupID;
    }

    public EggGroup(int eggGroupID, String eggGroupName, ArrayList<String> species) {
        this.eggGroupID = eggGroupID;
        this.eggGroupName = eggGroupName;
        this.species = species;
    }



    public static final Creator<EggGroup> CREATOR = new Creator<EggGroup>() {
        @Override
        public EggGroup createFromParcel(Parcel in) {
            return new EggGroup(in);
        }

        @Override
        public EggGroup[] newArray(int size) {
            return new EggGroup[size];
        }
    };

    public EggGroup(Parcel in) {
    }

    public int getEggGroupID() {
        return eggGroupID;
    }

    public void setEggGroupID(int eggGroupID) {
        this.eggGroupID = eggGroupID;
    }

    public String getEggGroupName() {
        return eggGroupName;
    }

    public void setEggGroupName(String eggGroupName) {
        this.eggGroupName = eggGroupName;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(eggGroupID);
        parcel.writeString(eggGroupName);
        parcel.writeList(species);

    }


}
