package com.geekchtech.hw3android1povtor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeFragment extends Fragment {
    private FloatingActionButton fab;
    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        requireActivity().getSupportFragmentManager().setFragmentResultListener("form", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                adapter.addItem(new Model(result.getString("text1"), result.getString("text2")));
            }
        });


        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.cont, new FormFragment()).commit();
        });

    }
}