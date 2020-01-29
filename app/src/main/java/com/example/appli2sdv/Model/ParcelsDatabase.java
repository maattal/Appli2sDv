package com.example.appli2sdv.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.appli2sdv.Entities.Converters;
import com.example.appli2sdv.Entities.Parcel;
//export shema false jai trouvee sur internet pour virer le bug du schema bla bla
@Database(entities = {Parcel.class}, version =2,exportSchema = false)
@TypeConverters({Converters.class})
public abstract class ParcelsDatabase extends RoomDatabase
{
   public abstract ParcelsDao parcelsDao();

    private static ParcelsDatabase instance;

    public static synchronized ParcelsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ParcelsDatabase.class, "parcels_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    //(allowMainThreadQueries)
}
