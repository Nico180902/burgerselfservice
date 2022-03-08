package com.ntraining;

public class Tomato implements Ingredient {
    @Override
    public double getPrice() {
        return 0.5;
    }

    @Override
    public String toString() {
        return "Tomato{}";
    }
}
