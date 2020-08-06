package com.example.a3605.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a3605.R;
import com.example.a3605.model.ProductModel;

//This class is based on the BreedSearcherHomework3Final (https://github.com/jellomarr/BreedSearcherHomework3FinalCopy) project's BreedDetailActivity.java class. The difference with this Activity is that this class in term of the products from HnG.

public class SearchDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        Intent intent = getIntent();
        ProductModel product = (ProductModel) intent.getSerializableExtra("product");

        TextView product_name = findViewById(R.id.product_name);
        TextView weight = findViewById(R.id.product_weight);
        TextView width = findViewById(R.id.product_width);
        TextView depth = findViewById((R.id.depth));
        TextView department = findViewById((R.id.product_department));
        TextView store = findViewById((R.id.product_store));
        TextView height = findViewById((R.id.product_height));
        TextView product_price = findViewById((R.id.product_price));
        TextView product_feature = findViewById((R.id.product_feature));
        ImageView product_picture = findViewById((R.id.product_picture));

        product_feature.setText(product.getFeature());
        product_name.setText(product.getProduct_name());
        product_price.setText(""+product.getPrice());
        weight.setText(product.getWeight()+"");
        width.setText(product.getWidth()+"");
        height.setText(product.getHeight()+"");
        department.setText(product.getProduct_departments());
        store.setText(product.getProduct_stores());
        Glide.with(this).load(product.getImage_url()).into(product_picture);
    }
}
