package com.example.breedsearcherhomework3.Database;

import com.example.breedsearcherhomework3.Model.Breed;

import java.util.HashMap;
import java.util.List;

public class FavBreedsDatabase {
    //hashmap allows for the same breed not to appear more than once
        private static HashMap<String, Breed> favBreeds = new HashMap<>();

        public static Breed getBreedByID(String id) {
            return favBreeds.get(id);
        }

        public static HashMap<String, Breed> getFavBreeds() {
            return favBreeds;
        }

        public static void saveFavBreedsToFakeDatabase(List<Breed> breedToSave) {
            for(int i = 0; i < breedToSave.size(); i++) {
                Breed breed = breedToSave.get(i);
                favBreeds.put(breed.getId(), breed);
            }
            System.out.println(favBreeds);
        }
    }

