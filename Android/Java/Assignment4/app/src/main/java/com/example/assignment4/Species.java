package com.example.assignment4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Species implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int speciesID;

    @ColumnInfo(name = "speciesname")
    String speciesName;

    @ColumnInfo(name = "egg_group1")
    String eggGroup1;

    @ColumnInfo(name = "egg_group2")
    String eggGroup2;

    @ColumnInfo(name = "egg_group3")
    String eggGroup3;

    public Species() {
    }

    public Species(int speciesID) {
        this.speciesID = speciesID;
    }

    public Species(int speciesID, String speciesName, String eggGroup1, String eggGroup2, String eggGroup3) {
        this.speciesID = speciesID;
        this.speciesName = speciesName;
        this.eggGroup1 = eggGroup1;
        this.eggGroup2 = eggGroup2;
        this.eggGroup3 = eggGroup3;
    }

    protected Species(Parcel in) {
        speciesID = in.readInt();
        speciesName = in.readString();
        eggGroup1 = in.readString();
        eggGroup2 = in.readString();
        eggGroup3 = in.readString();
    }

    public static final Creator<Species> CREATOR = new Creator<Species>() {
        @Override
        public Species createFromParcel(Parcel in) {
            return new Species(in);
        }

        @Override
        public Species[] newArray(int size) {
            return new Species[size];
        }
    };

    public int getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(int speciesID) {
        this.speciesID = speciesID;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getEggGroup1() {
        return eggGroup1;
    }

    public void setEggGroup1(String eggGroup1) {
        this.eggGroup1 = eggGroup1;
    }

    public String getEggGroup2() {
        return eggGroup2;
    }

    public void setEggGroup2(String eggGroup2) {
        this.eggGroup2 = eggGroup2;
    }

    public String getEggGroup3() {
        return eggGroup3;
    }

    public void setEggGroup3(String eggGroup3) {
        this.eggGroup3 = eggGroup3;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(speciesID);
        parcel.writeString(speciesName);
        parcel.writeString(eggGroup1);
        parcel.writeString(eggGroup2);
        parcel.writeString(eggGroup3);
    }
}
