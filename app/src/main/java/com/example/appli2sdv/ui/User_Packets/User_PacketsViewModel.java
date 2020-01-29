package com.example.appli2sdv.ui.User_Packets;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appli2sdv.Entities.Parcel;
import com.example.appli2sdv.Model.Repository;

import java.util.List;

public class User_PacketsViewModel extends AndroidViewModel
{
    private Repository repository;
    private LiveData<List<Parcel>> allparcels;

    public User_PacketsViewModel(@NonNull Application application)
    {
        super(application);
        repository = new Repository(application);
        repository.getHistoryParcels();
        allparcels = repository.getAllParcels();
    }
}