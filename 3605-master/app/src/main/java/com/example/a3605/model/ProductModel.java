package com.example.a3605.model;

public class ProductModel {
    private int product_id;
    private String product_name;
    private float price;
    private String image_url;
    private float weight;
    private float width;
    private String feature;
    private float height;
    private String description;
    private String product_stores;
    private String product_departments;
    private String store_addresses;
    private String store_phone_numbers;
    private String department_phone_number;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {

        if (image_url == null){
            this.image_url = "https://us.123rf.com/450wm/pavelstasevich/pavelstasevich1811/pavelstasevich181101028/112815904-stock-vector-no-image-available-icon-flat-vector-illustration.jpg?ver=6";
        }else{
            this.image_url = image_url;
        }
    }


    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_stores() {
        return product_stores;
    }

    public void setProduct_stores(String product_stores) {
        this.product_stores = product_stores;
    }

    public String getProduct_departments() {
        return product_departments;
    }

    public void setProduct_departments(String product_departments) {
        this.product_departments = product_departments;
    }

    public String getStore_addresses() {
        return store_addresses;
    }

    public void setStore_addresses(String store_addresses) {
        this.store_addresses = store_addresses;
    }

    public String getStore_phone_numbers() {
        return store_phone_numbers;
    }

    public void setStore_phone_numbers(String store_phone_numbers) {
        this.store_phone_numbers = store_phone_numbers;
    }

    public String getDepartment_phone_number() {
        return department_phone_number;
    }

    public void setDepartment_phone_number(String department_phone_number) {

        if (department_phone_number == null){
            this.department_phone_number = "no department phone number";
        }else {
            this.department_phone_number = department_phone_number;
        }
    }

    public ProductModel(){

    }


}
