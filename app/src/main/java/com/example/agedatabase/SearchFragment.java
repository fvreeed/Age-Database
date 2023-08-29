package com.example.agedatabase;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_search, container, false);

        Button btnSearch = view.findViewById(R.id.btnSearch);

        final EditText editSearch = view.findViewById(R.id.editSearch);

        final TextView textResult = view.findViewById(R.id.textResult);

        final DataManager dm = new DataManager(getActivity());

        btnSearch.setOnClickListener(view1 -> {

            Cursor c = dm.searchName(editSearch.getText().toString());

            if (c.getCount() > 0) {
                c.moveToNext();
                textResult.setText("Result = " +
                        c.getString(1) + " - " +
                        c.getString(2));
            }
        });

        return  view;
    }
}
