package com.example.a3605.fragments;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3605.R;

import com.example.a3605.adapter.ProductSearchAdapter;
import com.example.a3605.fakedatabase.ProductHolder;
import com.example.a3605.model.ApiResponseModel;
import com.example.a3605.model.ProductModel;
import com.google.gson.Gson;

import java.util.List;


public class SearchFragment extends Fragment {

    @SuppressLint("StaticFieldLeak")
    private static Spinner departmentSpinner;
    @SuppressLint("StaticFieldLeak")
    private static Spinner locationSpinner;
    @SuppressLint("StaticFieldLeak")
    private static SearchView searchBar;
    @SuppressLint("StaticFieldLeak")
    private static Button searchButton;
    @SuppressLint("StaticFieldLeak")
    private static View v;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        //return inflater.inflate(R.layout.fragment_search_recycler, container, false);
        v = inflater.inflate(R.layout.fragment_search_recycler, container, false);

        departmentSpinner = v.findViewById(R.id.dep_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getContext(), R.array.department, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(adapter1);
        departmentSpinner.setSelection(0);

        locationSpinner = v.findViewById(R.id.location_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getContext(), R.array.location, android.R.layout.simple_spinner_item);
        adapter2 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter2);
        locationSpinner.setSelection(0);

        searchButton = v.findViewById(R.id.button);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkWhatIsSelected();
            }
        });

        searchBar = v.findViewById(R.id.search_bar);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                checkWhatIsSelected();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        //when doing Gson, get the thing use the ApiResponseModel, but use the methods to get the problems.

        return v;
    }

    public static void checkWhatIsSelected(){

        String filledSpace = "%20";
        String productSearchTerm = "";
        String departmentSearchTerm = "";
        String locationSearchTerm = "";
        String apiCallURL = "";


        if (!searchBar.getQuery().toString().isEmpty() && !departmentSpinner.getSelectedItem().toString().equals("No Selection") && !locationSpinner.getSelectedItem().toString().equals("No Selection")){
            System.out.println("product, department and location were selected");

            System.out.println(searchBar.getQuery().toString().replace(" ", filledSpace));
            productSearchTerm = searchBar.getQuery().toString().replace(" ", filledSpace);

            System.out.println(departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            departmentSearchTerm = departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            System.out.println(locationSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            locationSearchTerm = locationSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproductanddepartmentandstores&productsearchterm=" + productSearchTerm + "&departmentsearchterm=" + departmentSearchTerm + "&storesearchterm=" + locationSearchTerm;

            apiCALL(apiCallURL, v);






        }
        else if (!searchBar.getQuery().toString().isEmpty() && !departmentSpinner.getSelectedItem().toString().equals("No Selection") && locationSpinner.getSelectedItem().toString().equals("No Selection")){
            System.out.println("product and department selected");

            System.out.println(searchBar.getQuery().toString().replace(" ", filledSpace));
            productSearchTerm = searchBar.getQuery().toString().replace(" ", filledSpace);

            System.out.println(departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            departmentSearchTerm = departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproductanddepartment&productsearchterm=" + productSearchTerm + "&departmentsearchterm=" + departmentSearchTerm;

            apiCALL(apiCallURL, v);

        }
        else if (!searchBar.getQuery().toString().isEmpty() && !locationSpinner.getSelectedItem().toString().equals("No Selection") && departmentSpinner.getSelectedItem().toString().equals("No Selection")){
            System.out.println("product and location selected");

            System.out.println(searchBar.getQuery().toString().replace(" ", filledSpace));
            productSearchTerm = searchBar.getQuery().toString().replace(" ", filledSpace);

            System.out.println(locationSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            locationSearchTerm = locationSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproductandstores&productsearchterm=" + productSearchTerm + "&storesearchterm=" + locationSearchTerm;

            apiCALL(apiCallURL, v);


        }
        else if (!locationSpinner.getSelectedItem().toString().equals("No Selection") && !departmentSpinner.getSelectedItem().toString().equals("No Selection") && searchBar.getQuery().toString().isEmpty()){
            System.out.println("location and department selected");

            System.out.println(departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            departmentSearchTerm = departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            System.out.println(locationSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            locationSearchTerm = locationSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingdepartmentandstores&departmentsearchterm=" + departmentSearchTerm + "&storesearchterm=" + locationSearchTerm;
            apiCALL(apiCallURL, v);

        }
        else if (!searchBar.getQuery().toString().isEmpty() && departmentSpinner.getSelectedItem().toString().equals("No Selection") && locationSpinner.getSelectedItem().toString().equals("No Selection")){
            System.out.println("product selected");

            System.out.println(searchBar.getQuery().toString().replace(" ", filledSpace));
            productSearchTerm = searchBar.getQuery().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingproduct&productsearchterm=" + productSearchTerm;

            apiCALL(apiCallURL, v);

        }
        else if (!departmentSpinner.getSelectedItem().toString().equals("No Selection") && locationSpinner.getSelectedItem().toString().equals("No Selection") && searchBar.getQuery().toString().isEmpty()){
            System.out.println("Department Selected");
            System.out.println(departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            departmentSearchTerm = departmentSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingdepartment&departmentsearchterm=" + departmentSearchTerm;

            apiCALL(apiCallURL, v);

        }
        else if (!locationSpinner.getSelectedItem().toString().equals("No Selection") && departmentSpinner.getSelectedItem().toString().equals("No Selection") && searchBar.getQuery().toString().isEmpty()){
            System.out.println("Location Selected");
            System.out.println(locationSpinner.getSelectedItem().toString().replace(" ", filledSpace));
            locationSearchTerm = locationSpinner.getSelectedItem().toString().replace(" ", filledSpace);

            apiCallURL = "http://group5hngdatabase.000webhostapp.com/Api.php?apicall=getproductsknowingstores&storesearchterm=" + locationSearchTerm;
            apiCALL(apiCallURL, v);

        }

    }

    private static void apiCALL(String url, final View view){
        //here format strings with spaces with "%" if needed
        RequestQueue  mRequestQueue = Volley.newRequestQueue(view.getContext());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            //"response" is basically the string that contains the json data
            public void onResponse(String response) {
                System.out.println("There is a response");
                System.out.println(response);

                RecyclerView recyclerView = view.findViewById(R.id.rv_main);
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                Gson gson = new Gson();

                ApiResponseModel apiResponse = gson.fromJson(response, ApiResponseModel.class);

                System.out.println(apiResponse.getProducts());

                if (apiResponse.isError()){
                    System.out.println("Big man");
                }else{
                    ProductSearchAdapter productSearchAdapter = new ProductSearchAdapter();

                    productSearchAdapter.setData(apiResponse.getProducts());

                    recyclerView.setAdapter(productSearchAdapter);
                }








            }
        };

        //operates if there is an error or simply no responses
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                System.out.println("Failed");
            }
        };


        //asks for a string from the address contained in the "url" string via the GET method, using the the last two arguments to state the types of listeners to use if there is a response and if there is not.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);

        //adds previous request to the mRequestQueue.
        mRequestQueue.add(stringRequest);
    }






}
