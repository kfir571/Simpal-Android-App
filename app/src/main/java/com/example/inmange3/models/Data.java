package com.example.inmange3.models;

import java.util.Date;
import java.util.List;

public class Data {
    private List<Meals> meals;

    public Data(List<Meals> meals){
        this.meals = meals;
    }


    public List<Meals> getMeals() {
        return meals;
    }
    public Meals getMeal(int poz) {
        return meals.get(poz);
    }
}
