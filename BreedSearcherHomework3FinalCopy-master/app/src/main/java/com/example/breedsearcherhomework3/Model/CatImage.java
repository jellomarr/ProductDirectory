package com.example.breedsearcherhomework3.Model;

//represents the image array that gets returned from the API. Only need the url.
// for getters, I have dealt with cases when the values are null, returning value to prevent a null pointer exception
public class CatImage {

    private String url;

    public CatImage(){

    }

    public String getUrl() {
        return getString(url);
    }

    final public static String getString(String value){
        try{
            return value;
        }catch (NullPointerException ex){
            return "not available";
        }
    }
}
