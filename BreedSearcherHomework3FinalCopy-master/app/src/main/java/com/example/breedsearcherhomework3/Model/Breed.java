package com.example.breedsearcherhomework3.Model;

//represent the require data that needs to be displayed for each breed
//setters will deal with cases if the value is null, return a value to prevent a null pointer exception
public class Breed {
    private String id;
    private String name;
    private String description;
    private String temperament;
    private String origin;
    private String life_span;
    private String wikipedia_url;
    private int dog_friendly;
    private Weight weight;


    //the "weight" value in Json is an array containing values for imperial and metric weights, hence this inner class
    public class Weight {
        private String imperial;
        private String metric;

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public Weight() {

        }

        public String getImperial() {
            return getString(imperial);
        }

        public String getMetric(){
            return getString(metric);
        }

    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
    // deals with the case that the weight is null

    public String getId() {
        return getString(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return getString(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return getString(description);
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public String getTemperament() {
        return getString(temperament);
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return getString(origin);
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLife_span() {
        return getString(life_span);
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getWikipedia_url() {
        return getString(wikipedia_url);
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public int getDog_friendly() {
        return getInt(dog_friendly);
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    //deals with null pointers for getting values
    final public static String getString(String value){
        try{
            return value;
        }catch (NullPointerException ex){
            return "not available";
        }

    }

    final public static int getInt(int value){
        try{
            return value;
        }catch (NullPointerException ex){
            return 0;
        }
    }



}



