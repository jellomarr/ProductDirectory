package com.example.a3605.model;
import java.util.ArrayList;

public class ApiResponseModel {
    private ArrayList<ProductModel> products;
    private boolean error;
    private String message;

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
