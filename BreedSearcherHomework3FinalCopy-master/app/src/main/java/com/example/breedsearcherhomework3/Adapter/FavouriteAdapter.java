package com.example.breedsearcherhomework3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.breedsearcherhomework3.Activity.BreedDetailActivity;
import com.example.breedsearcherhomework3.Database.BreedDatabase;
import com.example.breedsearcherhomework3.Model.Breed;
import com.example.breedsearcherhomework3.R;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavBreedsViewHolder>{


    private List<Breed> favBreedsToAdapt;

    public void setData(List<Breed> articlesToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.favBreedsToAdapt = articlesToAdapt;
    }

    @NonNull
    @Override
    public FavouriteAdapter.FavBreedsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.breed_viewholder, parent, false);

        FavouriteAdapter.FavBreedsViewHolder bookViewHolder = new FavouriteAdapter.FavBreedsViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.FavBreedsViewHolder holder, int position) {
        final Breed breedAtPosition = favBreedsToAdapt.get(position);
        holder.bind(breedAtPosition);


    }

    @Override
    public int getItemCount() {

        return favBreedsToAdapt.size();
    }

//class defines the viewholder object for each breed
    public class FavBreedsViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView breedName;

        public FavBreedsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.breedName = itemView.findViewById(R.id.breedName);
        }

        public void bind(final Breed breed) {
            breedName.setText(breed.getName());


            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, BreedDetailActivity.class);
                    intent.putExtra("id", breed.getId());
                    context.startActivity(intent);
                }
            });


        }

    }






}
