package com.example.agedatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class InsertFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_insert, container, false);

        final DataManager dm = new DataManager(getActivity());

        Button btnInsert = view.findViewById(R.id.btnInsert);

        final EditText editName = view.findViewById(R.id.editName);

        final EditText editAge = view.findViewById(R.id.editAge);

        btnInsert.setOnClickListener(view1 -> dm.insert(editName.getText().toString(), editAge.getText().toString()));

        return view;
    }
}
