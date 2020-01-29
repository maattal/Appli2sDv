package com.example.appli2sdv.ui.Friends_Packets;

import android.app.Application;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appli2sdv.Entities.Parcel;
import com.example.appli2sdv.Model.Repository;
import com.example.appli2sdv.ui.ParcelAdapter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Friends_PacketsViewModel extends AndroidViewModel {

    private LiveData<List<Parcel>> allparcels;
    private Repository myrepository;

    //constructor quon appelle dans le fragment
    public Friends_PacketsViewModel(@NonNull Application application)
    {
       super(application);
       myrepository=new Repository((getApplication()));
       myrepository.getHistoryParcels();
       allparcels=myrepository.getAllParcels();
}

    public LiveData<List<Parcel>> getAllParcels() {

        return allparcels;
    }
}