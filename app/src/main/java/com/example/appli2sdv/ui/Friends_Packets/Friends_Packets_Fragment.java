package com.example.appli2sdv.ui.Friends_Packets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appli2sdv.Entities.Parcel;
import com.example.appli2sdv.R;
import com.example.appli2sdv.ui.ParcelAdapter;

import java.util.List;

public class Friends_Packets_Fragment extends Fragment {

    private Friends_PacketsViewModel friendsPacketsViewModel;
    private ParcelAdapter myadapter;
    private RecyclerView friendRecyclerView;
    private RecyclerView.LayoutManager layoutmanger;
    View root;

    public static Friends_Packets_Fragment newInstance() {
        return new Friends_Packets_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState)
    {
        root= inflater.inflate(R.layout.fragment_friends_packets, container, false);
        return root;

}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        friendRecyclerView = (RecyclerView) root.findViewById(R.id.friendsParcels_recycleView);
        friendRecyclerView.setHasFixedSize(true);
        layoutmanger = new LinearLayoutManager(getContext());
        friendRecyclerView.setLayoutManager(layoutmanger);
        myadapter = new ParcelAdapter(getContext());
        friendRecyclerView.setAdapter(myadapter);

        friendsPacketsViewModel = ViewModelProviders.of(this).get(Friends_PacketsViewModel.class);
        friendsPacketsViewModel.getAllParcels().observe(this, new Observer<List<Parcel>>()
        {
            @Override
            public void onChanged(List<Parcel> parcels) {
                Log.d("FriendsPacketsFragment", String.valueOf(parcels.size()));
                myadapter.setList(parcels);
            }
        });
    }


    }