package com.example.breedsearcherhomework3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breedsearcherhomework3.Activity.BreedDetailActivity;
import com.example.breedsearcherhomework3.Model.Breed;

//jihjkj
import com.example.breedsearcherhomework3.R;

import java.util.List;

//loads data from search results into a view holder

public class BreedSearchAdapter extends RecyclerView.Adapter<BreedSearchAdapter.BreedSearchViewHolder>{

    private List<Breed> breedsToAdapt;

    public void setData(List<Breed> articlesToAdapt) {
        // This is basically a setter that we use to give data to the adapter
        this.breedsToAdapt = articlesToAdapt;
    }


    @NonNull
    @Override
    public BreedSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.breed_viewholder, parent, false);

        BreedSearchViewHolder breedViewHolder = new BreedSearchViewHolder(view);
        return breedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BreedSearchViewHolder holder, int position) {
        final Breed breedAtPosition = breedsToAdapt.get(position);

        holder.bind(breedAtPosition);


    }

    @Override
    public int getItemCount() {
        return breedsToAdapt.size();
    }

    public class BreedSearchViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView breedName;

        public BreedSearchViewHolder(@NonNull View itemView) {
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
