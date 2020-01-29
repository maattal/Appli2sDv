package com.example.appli2sdv.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appli2sdv.R;

public class MainActivity extends AppCompatActivity {
// la dedans on va mettre firebase authentification
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myintent=new Intent(MainActivity.this, ND_appli2.class);
        startActivity(myintent);
    }
}
