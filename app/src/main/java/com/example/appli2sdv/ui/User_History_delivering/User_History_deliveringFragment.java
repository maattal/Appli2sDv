package com.example.appli2sdv.ui.User_History_delivering;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appli2sdv.R;

public class User_History_deliveringFragment extends Fragment {

    private User_History_deliveringViewModel userHistorydeliveringViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userHistorydeliveringViewModel =
                ViewModelProviders.of(this).get(User_History_deliveringViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history_delivering, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        userHistorydeliveringViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}