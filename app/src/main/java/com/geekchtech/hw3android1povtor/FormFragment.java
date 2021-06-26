package com.geekchtech.hw3android1povtor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FormFragment extends Fragment {
private EditText editText1,editText2;
private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_fragmet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText1 = view.findViewById(R.id.et_one);
        editText2 = view.findViewById(R.id.et_two);
        button = view.findViewById(R.id.form_btn);

        button.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("text1", editText1.getText().toString());
            bundle.putString("text2", editText2.getText().toString());
            FormFragment.this.getActivity().getSupportFragmentManager().setFragmentResult("form",bundle);
            FormFragment.this.getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}