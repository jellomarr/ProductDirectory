package com.example.breedsearcherhomework3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.breedsearcherhomework3.Adapter.BreedSearchAdapter;
import com.example.breedsearcherhomework3.Database.BreedDatabase;
import com.example.breedsearcherhomework3.Model.Breed;
import com.example.breedsearcherhomework3.R;
import com.google.gson.Gson;

import java.util.Arrays;

public class BreedSearchFragment  extends Fragment {
    public BreedSearchFragment() {
        // Required empty public constructor iuhkvlfkjhgfd
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.breed_search_recycler_view, container, false);

        final SearchView searchBar = view.findViewById(R.id.searchBar);


        //allows the results to be updated in real time as the user changes the words in their bar
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String url = "https://api.thecatapi.com/v1/breeds/search?q=" + searchBar.getQuery();
                searchBreed(url, view);
                System.out.println("Search results found");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String url = "https://api.thecatapi.com/v1/breeds/search?q=" + searchBar.getQuery();
                searchBreed(url, view);
                return false;
            }
        });




        return view;


    }

    // basiclly setting the data from the json response
    private void searchBreed(String url, final View view){

        //creates a RequestQueue, which is basically a list of requests
        RequestQueue mRequestQueue = Volley.newRequestQueue(view.getContext());


        //operates if there's a response from the server
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            //"response" is basically the string that contains the json data
            public void onResponse(String response) {
                System.out.println("Thing works");
                RecyclerView recyclerView = view.findViewById(R.id.rv);
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);
                BreedSearchAdapter breedAdapter = new BreedSearchAdapter();

                //create a new gson object
                Gson gson = new Gson();

                //convert results to java objects and adds them to a hashmap, see "Database" package
                Breed[] breedSearchResult = gson.fromJson(response, Breed[].class);
                BreedDatabase.saveBreedsToFakeDatabase(Arrays.asList(breedSearchResult));
                breedAdapter.setData(Arrays.asList(breedSearchResult));
                recyclerView.setAdapter(breedAdapter);
                System.out.println("Adapter has been set");
            }
        };

        //operates if there is an error or simply no responses
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Failed");
            }
        };


        //asks for a string from the address contained in the "url" string via the GET method, using the the last two arguments to state the types of listeners to use if there is a response and if there is not.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);

        //adds previous request to the mRequestQueue.
        mRequestQueue.add(stringRequest);






    }






}
