package com.example.breedsearcherhomework3.Database;

import com.example.breedsearcherhomework3.Model.Breed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BreedDatabase {
    private static HashMap<String, Breed> breeds = new HashMap<>();

    public static HashMap<String, Breed> getBreeds() {
        return breeds;
    }

    public static Breed getBreedByID(String id) {
        return breeds.get(id);
    }

    public static void saveBreedsToFakeDatabase(List<Breed> breedToSave) {
        for(int i = 0; i < breedToSave.size(); i++) {
            Breed breed = breedToSave.get(i);
            breeds.put(breed.getId(), breed);
        }
        System.out.println(breeds);
    }
}
