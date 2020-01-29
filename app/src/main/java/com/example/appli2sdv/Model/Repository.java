package com.example.appli2sdv.Model;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.appli2sdv.Entities.Parcel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Objects;


public class Repository {
    private static final String TAG = "Repository";
    private  ParcelsDao parcelsDao;//reference de room

    private final LiveData<List<Parcel>> allParcels;

    private DatabaseReference parcelsRef;//reference de firebase

    public Repository(Application application)
    {
        ParcelsDatabase database = ParcelsDatabase.getInstance(application); //instance de room et c'est pour ca qu'on recoit un context dans le constructor
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //instance de firebase
        parcelsDao = database.parcelsDao();
        parcelsRef = firebaseDatabase.getReference("Parcels");
        // Should fix bug
        parcelsRef.keepSynced(true);
        allParcels  = parcelsDao.getAllParcels();
    }

    //insert - la on fait que le keta du room puisqu'on ecrit pas ici dans firebase mais dans la premiere appli
    public void insert(Parcel parcel) {
        new InsertParcelAsyncTask(parcelsDao).execute(parcel);
    }

    public void deleteAll(){
        new DeleteAllParcelAsyncTask(parcelsDao).execute();

    }

    public void getHistoryParcels(){

       parcelsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    // Cleans the whole database such as not to duplicate data
                    deleteAll();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Parcel parcel = snapshot.getValue(Parcel.class); //ca ca lit de firebase
                        insert(parcel);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private static class InsertParcelAsyncTask extends AsyncTask<Parcel, Void, Void> {
        private ParcelsDao parcelsDao;
        private InsertParcelAsyncTask(ParcelsDao parcelsDao) {
            this.parcelsDao = parcelsDao;
        }

        protected Void doInBackground(Parcel... parcels) {
            for (Parcel parcel : parcels)
            {
                Log.d(TAG,"insert");
                parcelsDao.insert(parcel);
            }
            return null;
        }
    }

    private static class DeleteAllParcelAsyncTask extends AsyncTask<Void, Void, Void> {
        private ParcelsDao parcelsDao;
        private DeleteAllParcelAsyncTask(ParcelsDao parcelsDao) {
            this.parcelsDao = parcelsDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            parcelsDao.deleteAllParcels();
            return null;
        }
    }
    //lui il lit de room
    public LiveData<List<Parcel>> getAllParcels() {
        return allParcels;
    }

}
