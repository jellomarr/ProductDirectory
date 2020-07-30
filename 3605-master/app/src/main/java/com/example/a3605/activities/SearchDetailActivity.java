package com.example.a3605.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a3605.R;
import com.example.a3605.model.ProductModel;


public class SearchDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        Intent intent = getIntent();
        final String intentID = intent.getStringExtra("id");

        TextView product_name = findViewById(R.id.product_name);
        TextView weight = findViewById(R.id.weight);
        TextView width = findViewById(R.id.width);
        TextView locations = findViewById((R.id.locations));

    }
}
