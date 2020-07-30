package com.example.breedsearcherhomework3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.breedsearcherhomework3.Database.BreedDatabase;
import com.example.breedsearcherhomework3.Database.FavBreedsDatabase;
import com.example.breedsearcherhomework3.Model.Breed;
import com.example.breedsearcherhomework3.Model.CatImage;
import com.example.breedsearcherhomework3.R;
import com.google.gson.Gson;



public class BreedDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_detail_view);

        Intent intent = getIntent();
        final String intentID = intent.getStringExtra("id");

        final Breed breed = BreedDatabase.getBreedByID(intentID);

        TextView name = findViewById(R.id.name);
        TextView lifespan = findViewById(R.id.lifespan);
        TextView origin = findViewById(R.id.origin);
        TextView description = findViewById(R.id.description);
        TextView temperament  = findViewById(R.id.temperament);
        TextView wiki = findViewById(R.id.wikipedia);
        TextView dogFriendly = findViewById(R.id.textView2);
        Button addBreedButton = findViewById(R.id.addBreedButton);
        TextView weightImperial = findViewById(R.id.weightImperial);
        TextView weightMetric = findViewById(R.id.weightMetric);


   //for adding breeds to favourites
        addBreedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FavBreedsDatabase.getFavBreeds().put(intentID, breed);
                Toast.makeText(getBaseContext(),"Breed added", Toast.LENGTH_SHORT).show();
                System.out.println("breed added");
            }
        });

        String apikey = "880bafd2-5d32-4024-a66a-fc56637d678e";
        String url = "https://api.thecatapi.com/v1/images/search?api_key="+apikey+"&breed_id="+breed.getId();

        setCatImage(url, this.findViewById(android.R.id.content));

        setText(breed.getName(), name);
        setText("Lifespan is; " + breed.getLife_span(), lifespan);
        setText("This breed is from " + breed.getOrigin(), origin);
        setText("Temperament is "+ breed.getTemperament(), temperament);
        setText(breed.getDescription(), description);
        setText(breed.getWikipedia_url(), wiki);
        setText(" Dog friendly level " + Integer.toString(breed.getDog_friendly()), dogFriendly);

        if(breed.getWeight() != null){
            setText("Metric weight is " + breed.getWeight().getMetric() + "kgs", weightMetric);
            setText("Imperial weight is " + breed.getWeight().getMetric() + "lb", weightImperial);
        }
        else{
            setText("Metric weight is null",  weightMetric);
            setText("Imperial weight is null", weightImperial);
        }





    }



    //Aims to deal with a case where not all of the data is returned
    private void setText(String string, TextView textView){
        try{
            textView.setText(string);
            System.out.println(string);
        }
        catch(NullPointerException ex){
            textView.setText(R.string.no_value);
        }
        System.out.println(textView.getText());

    }

    private void setText(int num, TextView textView){

        if(num != 0){
            textView.setText(num);
        }
        else{
            textView.setText("Not Available");
        }

    }

    private void setCatImage(String url, final View view){

        //creates a RequestQueue, which is basically a list of requests
        RequestQueue mRequestQueue = Volley.newRequestQueue(view.getContext());


        //operates if there's a response from the server
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            //"response" is basically the string that contains the json data
            public void onResponse(String response) {
                System.out.println("Thing works");

                //create a new gson object
                Gson gson = new Gson();

                System.out.println("This is the value of response;" + response);
                CatImage[] catImage = gson.fromJson(response, CatImage[].class);
                ImageView catImageView = findViewById(R.id.imageView);
                System.out.println("Json does work");


                //aim to ensure things are able to be displayed if the image url cannot be found
                try {
                    // the reason I hardcoded this is because since all GET request in this case only returns one breed
                    Glide.with(getApplicationContext()).load(catImage[0].getUrl()).into(catImageView);
                    System.out.println("Image was loaded");
                } catch (Exception e) {
                    System.out.println("Json does not work");
                    e.printStackTrace();
                    Glide.with(getApplicationContext()).load("https://cdn2.thecatapi.com/images/dN6eoeLjY.jpg").into(catImageView);
                }

            }
        };
        //operates if there is an error or simply no response for the image url
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error");
                ImageView catImageView = findViewById(R.id.imageView);
                Glide.with(getApplicationContext()).load("https://cdn2.thecatapi.com/images/dN6eoeLjY.jpg").into(catImageView);
            }
        };


        //asks for a string from the address contained in the "url" string via the GET method, using the the last two arguments to state the types of listeners to use if there is a response and if there is not.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);

        //adds previous request to the mRequestQueue.
        mRequestQueue.add(stringRequest);



    }




}
