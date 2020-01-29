package com.example.appli2sdv.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appli2sdv.Entities.Parcel;

import java.util.List;

@Dao
public interface ParcelsDao {
    //insert il peut return void ou long il renvoie la primary key

    //abstract class de notedatabase dans le modele qui superclass de roomdatabase
    //il lui faut un mofa de cette class qui soit singleton donc on mets private static instance + getinstance les deux ensemble ca fait singleton
    //oblige de mettre un symchronize pour eviter que deux threads rentrent en meme temps.

        //onConflict = OnConflictStrategy.IGNORE
        @Insert
        long insert(Parcel parcel);

        @Update
        void update(Parcel parcel);

        @Delete
        void delete(Parcel parcel);

        @Query("SELECT * FROM parcels_table ORDER BY DeliveryName DESC")
        LiveData<List<Parcel>> getAllParcels();
}
