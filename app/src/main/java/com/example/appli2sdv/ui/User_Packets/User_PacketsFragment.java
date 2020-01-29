package com.example.appli2sdv.ui.User_Packets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.appli2sdv.R;

public class User_PacketsFragment extends Fragment {

    private User_PacketsViewModel userPacketsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user_packet, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        userPacketsViewModel = ViewModelProviders.of(this).get(User_PacketsViewModel.class);
    }
}