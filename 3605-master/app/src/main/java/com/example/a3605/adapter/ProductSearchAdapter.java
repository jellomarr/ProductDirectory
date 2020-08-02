package com.example.a3605.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3605.R;
import com.example.a3605.model.ProductModel;
import com.example.a3605.activities.SearchDetailActivity;
import java.util.List;

public class ProductSearchAdapter extends RecyclerView.Adapter<ProductSearchAdapter.ProductViewHolder>{

    private List<ProductModel> productsToAdapt;

    public void setData(List<ProductModel> productsToAdapt){
        this.productsToAdapt = productsToAdapt;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.search_view, parent, false);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        final ProductModel productAtPosition = productsToAdapt.get(position);

        holder.bind(productAtPosition);

        String imageUrl = "";
        imageUrl = productAtPosition.getImage_url();

        Glide.with(holder.view.getContext())
                .load(imageUrl)
                .error(R.drawable.ic_baseline_cloud_off_24)
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return productsToAdapt.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView productName;
        public TextView productPrice;
        public ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.productName = itemView.findViewById(R.id.product_name);
            this.productPrice = itemView.findViewById(R.id.product_price);
            this.productImage = itemView.findViewById(R.id.product_image);
        }


        public void bind(final ProductModel product) {
            productName.setText(product.getProduct_name());
            productPrice.setText(Float.toString(product.getPrice()));

            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, SearchDetailActivity.class);
                    intent.putExtra("id", product.getProduct_id());
                    context.startActivity(intent);
                }
            });

        }

    }
}
