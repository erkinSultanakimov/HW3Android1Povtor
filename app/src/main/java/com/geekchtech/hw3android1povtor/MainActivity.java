package com.geekchtech.hw3android1povtor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction().replace(R.id.cont,new HomeFragment());
        ft.commit();

    }
}