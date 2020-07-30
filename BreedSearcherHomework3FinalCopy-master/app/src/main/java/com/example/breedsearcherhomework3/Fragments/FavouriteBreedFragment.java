package com.example.breedsearcherhomework3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breedsearcherhomework3.Adapter.BreedSearchAdapter;
import com.example.breedsearcherhomework3.Adapter.FavouriteAdapter;
import com.example.breedsearcherhomework3.Database.FavBreedsDatabase;
import com.example.breedsearcherhomework3.Model.Breed;
import com.example.breedsearcherhomework3.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteBreedFragment extends Fragment {

    public FavouriteBreedFragment() {
        // Required empty public constructor iuhkvlfkjhgfd
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //
        View view = inflater.inflate(R.layout.fav_breed_recycler_view, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FavouriteAdapter favouriteAdapter = new FavouriteAdapter();
        //gets data from the database to be set in the adapter
        List<Breed> list = new ArrayList<Breed>(FavBreedsDatabase.getFavBreeds().values());
        favouriteAdapter.setData(list);
        recyclerView.setAdapter(favouriteAdapter);

        return view;

    }
}
