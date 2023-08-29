package com.example.agedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_results, container, false);

        final DataManager dm = new DataManager(getActivity());

        TextView textResults = view.findViewById(R.id.textResults);

        Cursor c = dm.selectAll();

        StringBuilder list = new StringBuilder();

        while (c.moveToNext()) {
            list.append(c.getString(1)).append(" - ").append(c.getString(2)).append("\n");
        }

        textResults.setText(list.toString());

        return view;
    }
}
