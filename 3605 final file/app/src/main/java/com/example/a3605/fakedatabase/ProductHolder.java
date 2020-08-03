package com.example.a3605.fakedatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.a3605.model.ProductModel;

public class ProductHolder {

    private static ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    public static ArrayList<ProductModel> getProducts() {
        return products;
    }

    public static void saveProductsToHolder(List<ProductModel> productsToSave) {
        for(int i = 0; i < productsToSave.size(); i++) {
            ProductModel productToAdd = productsToSave.get(i);
            products.add(productToAdd);

        }
    }
}
