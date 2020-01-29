package com.example.appli2sdv.Model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.appli2sdv.Entities.Parcel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Repository {
    private  ParcelsDao parcelsDao;//reference de room

    private final LiveData<List<Parcel>> allParcels;

    private DatabaseReference parcelsRef;//reference de firebase

    public Repository(Application application)
    {
        ParcelsDatabase database = ParcelsDatabase.getInstance(application); //instance de room et c'est pour ca qu'on recoit un context dans le constructor
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //instance de firebase
        parcelsDao = database.parcelsDao();
        parcelsRef = firebaseDatabase.getReference("Parcels");
        allParcels  = parcelsDao.getAllParcels();
    }

    //insert - la on fait que le keta du room puisqu'on ecrit pas ici dans firebase mais dans la premiere appli
    public void insert(Parcel parcel)
    {
        new InsertParcelAsyncTask(parcelsDao).execute(parcel);

    }

    public void getHistoryParcels()
    {
       parcelsRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Parcel parcel = snapshot.getValue(Parcel.class); //ca ca lit de firebase
                        //parcelsList.add(parcel);
                        insert(parcel);
                        //ca ca ajoute a room

                    }
                    // je mets comment que ladapter doit se bouger? mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private static class InsertParcelAsyncTask extends AsyncTask<Parcel, Void, Void>
    {
        private ParcelsDao parcelsDao;
        private InsertParcelAsyncTask(ParcelsDao parcelsDao) {
            this.parcelsDao = parcelsDao;
        }

        protected Void doInBackground(Parcel... parcels) {
            for (Parcel parcel : parcels)
            {
                parcelsDao.insert(parcel);
            }
            return null;
        }
    }
    //lui il lit de room
    public LiveData<List<Parcel>> getAllParcels() {
        return allParcels;
    }

}
