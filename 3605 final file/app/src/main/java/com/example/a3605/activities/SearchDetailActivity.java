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

import com.bumptech.glide.Glide;
import com.example.a3605.R;
import com.example.a3605.model.ProductModel;


public class SearchDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        Intent intent = getIntent();
        ProductModel product = (ProductModel) intent.getSerializableExtra("product");

        TextView product_name = findViewById(R.id.product_name);
        TextView weight = findViewById(R.id.product_weight);
        TextView width = findViewById(R.id.product_width);
        TextView locations = findViewById((R.id.locations));
        TextView textView9 = findViewById((R.id.textView9));
        TextView textView10 = findViewById((R.id.textView10));
        TextView heigth = findViewById((R.id.product_height));
        TextView product_price = findViewById((R.id.product_price));
        TextView product_feature = findViewById((R.id.product_feature));
        ImageView product_picture = findViewById((R.id.product_picture));
        product_feature.setText(product.getFeature());
        product_name.setText(product.getProduct_name());
        product_price.setText(""+product.getPrice());
        weight.setText(product.getWeight()+"");
        width.setText(product.getWidth()+"");
        heigth.setText(product.getHeight()+"");
        textView9.setText(product.getProduct_departments());
        textView10.setText(product.getProduct_stores());
        Glide.with(this).load(product.getImage_url()).into(product_picture);
    }
}
